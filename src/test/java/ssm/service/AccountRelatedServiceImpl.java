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

    @Test
    public void findARecordByEmailAndPassword(){
        String user_email = "mengleizzu@163.com";
        System.out.println(accountRelatedServiceImpl.findUserByEmailAddressAndPassword(user_email,"123456"));
    }

    @Test
    public  void updateHeadByEmailAddressAndPassword(){
        String user_email = "mengleizzu@163.com";
        accountRelatedServiceImpl.updateHeadByEmailAddressAndPassword(user_email,"1","2");
    }

    @Test
    public void updateUserByEmailAddress(){
        String email = "2271366490@qq.com";
        String userName = "孟磊";
        String userHeadPictureUrl = "1";
        int userSex = 1;

        Integer a = accountRelatedServiceImpl.updateUserByEmailAddressAndPassword(email,"1",userName,userHeadPictureUrl,userSex,Date.valueOf("2201-01-01"));
        System.out.println(a);
    }

    @Test
    public void updatePassword(){
        String email = "2271366490@qq.com";
        String oldPassword = "233333";
        String newPassword = "123456";
        accountRelatedServiceImpl.updatePassword(email,oldPassword,newPassword);
    }

}
