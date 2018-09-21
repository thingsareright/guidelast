package ssm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class AccountRelatedService {

    @Autowired
    ssm.service.impl.AccountRelatedService accountRelatedService;

    @Test
    public void sendEmailAndReturnStateTest(){
        String emailAddress = "mengleizzu@163.com";
        int state = accountRelatedService.sendEmailAndReturnState(emailAddress);
        System.out.println(state);
    }

}
