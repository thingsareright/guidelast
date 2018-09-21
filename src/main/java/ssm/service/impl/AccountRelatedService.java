package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import ssm.dao.UserDao;
import ssm.exception.SendAuthorCodeEmailFailException;
import ssm.utils.EmailUtil;

import javax.annotation.Resource;
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
}
