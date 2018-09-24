package ssm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import ssm.dao.UserDao;
import ssm.dto.UserInfoRegister;
import ssm.entity.User;
import ssm.exception.SendAuthorCodeEmailFailException;
import ssm.service.AccountedRelatedService;
import ssm.utils.EmailUtil;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 提供与账号和用户个人信息有关的业务支持
 */
@Service
public class AccountRelatedServiceImpl implements AccountedRelatedService {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    private static final int EMAILADDRESS_ALREADY_EXIST = 2;
    private static final int EMAILADDRESS_ALREADY_SEND = 1;
    private static final int EMAILADDRESS_CANNOT_SEND_AUTHORCODE = 3;

    private static final int REGISTER_OK = 1;
    private static final int REGISTER_EMAIL_REGISTERED = 2;
    private static final int REGISTER_TOKEN_WRONG = 3;
    private static final int REGISTER_CONFLICT_TOKEN = 4;

    private static final int LOGIN_SUCCESSFULLY = 1;
    private static final int NONE_LOGIN_EMAILADDRESS = 2;
    private static final int LOGIN_PASSWORD_WRONG = 3;

    private static final int OLD_PASSWORD_WRONG = 0;

    @Autowired
    UserDao userDao;
    @Resource
    private RedisTemplate redisTemplate;

    public boolean sendEmail(String emailAddress) {
        Random random = new Random();
        int authorCode = random.nextInt(1000000);
        try {
            //TODO 对邮箱格式进行验证
            EmailUtil.email(emailAddress, Integer.valueOf(authorCode));
            //把验证码放入缓存，并设置有效时间为十分钟
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(emailAddress, String.valueOf(authorCode), EmailUtil.TOKEN_TIME, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SendAuthorCodeEmailFailException("邮箱发送验证码失败");
        }
        return true;
    }

    /**
     * 注册第一步，验证邮箱是否可用
     * @param emailAddress
     * @return
     */
    public int sendEmailAndReturnState(String emailAddress){
        //先判断数据库里是否已经存在了该邮箱地址
        String emailAddressEqual = userDao.existEmailAddress(emailAddress);
        if (null != emailAddressEqual){
            logger.debug("sendEmailAndReturnState","EMAILADDRESS_ALREADY_EXIST");
            return EMAILADDRESS_ALREADY_EXIST;
        }
        try {
            sendEmail(emailAddress);
            logger.debug("sendEmailAndReturnState","EMAILADDRESS_SEND_SUCCESSFULLY");
        } catch (SendAuthorCodeEmailFailException e){
            logger.debug("sendEmailAndReturnState","EMAILADDRESS_CANNOT_SEND_AUTHORCODE");
            return EMAILADDRESS_CANNOT_SEND_AUTHORCODE;
        }
        return EMAILADDRESS_ALREADY_SEND;
    }

    public int registerWithEmailAddress(UserInfoRegister user) {
        //第一步，先查看邮箱地址是否已经被注册
        String emailAddressEqual = userDao.existEmailAddress(user.getUserEmail());
        if (null != emailAddressEqual){
            logger.debug("registerWithEmailAddress","REGISTER_EMAIL_REGISTERED");
            return REGISTER_EMAIL_REGISTERED;
        }
        //第二步，验证验证码是否正确
        //先从redis中获取验证码
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String token = String.valueOf(valueOperations.get(user.getUserEmail()));
        if (token.equals(user.getToken())){
            //如果验证码正确，那么执行注册插入逻辑
            logger.debug("registerWithEmailAddress","TOKEN_RIGHT");
            userDao.addAUser(user);
            logger.debug("registerWithEmailAddress","INSERT_USER_SUCCESSFULLY");
        } else {
            logger.debug("registerWithEmailAddress","REGISTER_TOKEN_WRONG");
            return REGISTER_TOKEN_WRONG;
        }
        logger.debug("registerWithEmailAddress","REGISTER_OK");
        return REGISTER_OK;
    }

    public int registerWithEmailAddress(UserInfoRegister userInfoRegister, String confirmPassword) {
        if (!confirmPassword.equals(userInfoRegister.getUserPassword())){
            logger.debug("registerWithEmailAddress","REGISTER_CONFLICT_TOKEN");
            return REGISTER_CONFLICT_TOKEN;
        } else {
            return registerWithEmailAddress(userInfoRegister);
        }
    }

    /**
     * 这个才是用于controller调用的
     * @param emailAddress
     * @param token
     * @param name
     * @param sex
     * @param birthday
     * @param password
     * @param confirmPassword
     * @param userPictureUrl
     * @return
     */
    @Override
    public int registerWithEmailAddress(String emailAddress, String token, String name, String sex, String birthday,
                                        String password, String confirmPassword, String userPictureUrl) {
        return registerWithEmailAddress(new UserInfoRegister(emailAddress,password,name,userPictureUrl,Integer.parseInt(sex), Date.valueOf(birthday),token), confirmPassword);
    }

    public int loginWithEmailAndPassword(String emailAddress, String password) {
        String emailInDb = userDao.existEmailAddress(emailAddress);
        if (null == emailInDb){
            return NONE_LOGIN_EMAILADDRESS;
        }
        String passwordInDb = userDao.findPasswordByEmailAddress(emailAddress);
        if (null != passwordInDb && password.equals(passwordInDb)){
            return LOGIN_SUCCESSFULLY;
        }
        return LOGIN_PASSWORD_WRONG;
    }

    /**
     * 根据邮箱和密码查用户信息
     */
    public User findUserByEmailAddressAndPassword(String emailAddress, String password){
        User user = userDao.findARecordByEmailAndPassword(emailAddress, password);
        return user;
    }

    /**
     * 修改头像
     * @param emailAddress
     * @param headFlag
     * @return 0表示没有修改成功，1表示修改成功 TODO 可返回更多的状态码
     */
    public Integer updateHeadByEmailAddressAndPassword(String emailAddress, String password, String headFlag){
        return userDao.updateHeadByEmailAddressAndPassword(emailAddress,password,headFlag);
    }

    /**
     * 修改个人信息
     * @param emailAddress
     * @param userName
     * @param headFlag
     * @param sex
     * @param birthday
     * @return
     */
    public Integer updateUserByEmailAddressAndPassword(String emailAddress,String password, String userName, String headFlag, int sex, Date birthday){
        return userDao.updateUserByEmailAddressAndPassword(emailAddress,password, userName,headFlag,sex,birthday);
    }

    /**
     * 修改密码
     * 先检查旧密码是否正确，再更新
     * @param emailAddress
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public Integer updatePassword(String emailAddress,String oldPassword,String newPassword){
        String old = userDao.checkOldPassword(emailAddress,oldPassword);
        if(null ==old){
            return OLD_PASSWORD_WRONG;
        }else {
            return userDao.updatePassword(emailAddress,newPassword);
        }
    }


}
