package ssm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.dto.UserInfoRegister;

import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class AccountRelatedServiceImpl {

    @Autowired
    ssm.service.impl.AccountRelatedServiceImpl accountRelatedServiceImpl;

    @Test
    public void sendEmailAndReturnStateTest(){
        String emailAddress = "mengleizzu@163.com";
        int state = accountRelatedServiceImpl.sendEmailAndReturnState(emailAddress);
        System.out.println(state);
    }

    @Test
    public void registerWithEmailAddressTest() {
        String emailAddress = "mengleizzu@163.com";
        String userPassword = "123456";
        String userName = "张杰";
        String userPictureUrl = "1";
        String userSex = "1";
        String birthday = "2018-01-01";
        String confirmPassword = "123456";
        String token = "862084";
        UserInfoRegister userInfoRegister = new UserInfoRegister(
                emailAddress,
                "Zhang9971123mll!",
                "张杰",
                "1",
                1,
                Date.valueOf("2018-09-21"),
                "534193h"
        );
        System.out.println(accountRelatedServiceImpl.registerWithEmailAddress(emailAddress, token,userName,userSex,birthday,userPassword,confirmPassword,
                userPictureUrl));
    }

}
