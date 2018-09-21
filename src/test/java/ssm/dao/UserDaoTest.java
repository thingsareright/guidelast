package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.User;

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
}
