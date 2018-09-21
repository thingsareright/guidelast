package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.UserDao;
import ssm.exception.SendAuthorCodeEmailFailException;
import ssm.utils.EmailUtil;

import java.util.Random;

/**
 * 提供与账号和用户个人信息有关的业务支持
 */
@Service
public class AccountRelatedService {

    @Autowired
    UserDao userDao;

    public boolean sendEmail(String email) {
        Random random = new Random();
        int authorCode = random.nextInt(1000000);
        try {
            //TODO 对邮箱格式进行验证
            EmailUtil.email(email, authorCode);
        } catch (Exception e) {
            throw new SendAuthorCodeEmailFailException("邮箱发送验证码失败");
        }
        return true;
    }
}
