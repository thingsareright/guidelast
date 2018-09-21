package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import ssm.dao.UserDao;
import ssm.dto.UserInfoRegister;
import ssm.entity.User;
import ssm.exception.SendAuthorCodeEmailFailException;
import ssm.utils.EmailUtil;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 提供与账号和用户个人信息有关的业务支持
 */
@Service
public class AccountRelatedService {

    private static final int EMAILADDRESS_ALREADY_EXIST = 2;
    private static final int EMAILADDRESS_ALREADY_SEND = 1;
    private static final int EMAILADDRESS_CANNOT_SEND_AUTHORCODE = 3;

    private static final int REGISTER_OK = 1;
    private static final int REGISTER_EMAIL_REGISTERED = 2;
    private static final int REGISTER_TOKEN_WRONG = 3;
    private static final int REGISTER_CONFLICT_TOKEN = 4;
    @Autowired
    UserDao userDao;
    @Resource
    private RedisTemplate redisTemplate;

    public boolean sendEmail(String emailAddress) {
        Random random = new Random();
        int authorCode = random.nextInt(1000000);
        try {
            //TODO 对邮箱格式进行验证,还都没有redis验证
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
            return EMAILADDRESS_ALREADY_EXIST;
        }
        try {
            sendEmail(emailAddress);
        } catch (SendAuthorCodeEmailFailException e){
            return EMAILADDRESS_CANNOT_SEND_AUTHORCODE;
        }
        return EMAILADDRESS_ALREADY_SEND;
    }

    public int registerWithEmailAddress(UserInfoRegister user) {
        //第一步，先查看邮箱地址是否已经被注册
        String emailAddressEqual = userDao.existEmailAddress(user.getUserEmail());
        if (null != emailAddressEqual){
            return REGISTER_EMAIL_REGISTERED;
        }
        //第二步，验证验证码是否正确
        //先从redis中获取验证码
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String token = String.valueOf(valueOperations.get(user.getUserEmail()));
        if (token.equals(user.getToken())){
            //如果验证码正确，那么执行注册插入逻辑
            userDao.addAUser(user);
        } else {
            return REGISTER_TOKEN_WRONG;
        }
        return REGISTER_OK;
    }

    public int registerWithEmailAddress(UserInfoRegister userInfoRegister, String confirmPassword) {
        if (confirmPassword.equals(userInfoRegister.getUserPassword())){
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
    public int registerWithEmailAddress(String emailAddress,String token, String name, String sex, String birthday,
                                        String password, String confirmPassword, String userPictureUrl) {
        return registerWithEmailAddress(new UserInfoRegister(emailAddress,password,name,userPictureUrl,Integer.parseInt(sex), Date.valueOf(birthday),token), confirmPassword);
    }
}
