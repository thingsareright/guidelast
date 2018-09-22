package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.User;

import java.sql.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void findARecordTest(){
        List<User> users = userDao.findARecord();
        for (User user:
             users) {
            System.out.println(user);
        }
    }

    @Test
    public void existEmailAddressTest() {
        String emailAddress = userDao.existEmailAddress("max@qq.com");
        System.out.println(emailAddress);
    }

    @Test
    public void addAUserTest() {
        String user_email = "mengleizzu@163.com";
        String user_password = "123456";
        System.out.println(userDao.addAUser(
                    new User(user_email,user_password,"孟磊","1",1, Date.valueOf("2010-08-20"))
                )
        );
    }

    @Test
    public void findPasswordByEmailAddressTest() {
        String user_email = "mengleizzu@16312.com";
        System.out.println(userDao.findPasswordByEmailAddress(user_email));
    }
}
