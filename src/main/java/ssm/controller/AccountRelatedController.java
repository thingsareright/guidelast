package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.entity.User;
import ssm.service.impl.AccountRelatedServiceImpl;

import java.sql.Date;

/**
 * 处理与用户账号有关的业务请求
 */
@Controller
public class AccountRelatedController {

    @Autowired
    private AccountRelatedServiceImpl accountRelatedServiceImpl;

    @RequestMapping(value = "/sendEmailAndReturnState", method = RequestMethod.GET)
    @ResponseBody
    public int sendEmailAndReturnState(@RequestParam(value = "emailAddress", defaultValue = "") String emailAddress){
        return accountRelatedServiceImpl.sendEmailAndReturnState(emailAddress);
    }

    @RequestMapping(value = "/registerWithEmailAddress", method = RequestMethod.POST)
    @ResponseBody
    public int registerWithEmailAddress(
            @RequestParam(value = "emailAddress", defaultValue = "") String emailAddress,
            @RequestParam(value = "token", defaultValue = "") String token,
            @RequestParam(value = "name", defaultValue = "无名之人") String name,
            @RequestParam(value = "sex", defaultValue = "1") String sex,
            @RequestParam(value = "birthday", defaultValue = "2018-01-01") String birthday,
            @RequestParam(value = "password", defaultValue = "123456") String password,
            @RequestParam(value = "confirmPassword", defaultValue = "123456") String confirmPassword,
            @RequestParam(value = "userPictureUrl", defaultValue = "1") String userPictureUrl
            ){
        return accountRelatedServiceImpl.registerWithEmailAddress(emailAddress, token,  name,  sex,  birthday,
                 password,  confirmPassword,  userPictureUrl);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public int loginIn(
            @RequestParam(value = "emailAddress", defaultValue = "emailAddress") String emailAddress,
            @RequestParam(value = "password", defaultValue = "") String password
    ){
        return  accountRelatedServiceImpl.loginWithEmailAndPassword(emailAddress, password);
    }

    @RequestMapping(value = "/findARecordByEmail", method = RequestMethod.POST)
    @ResponseBody
    public User findARecordByEmail(@RequestParam(value = "emailAddress",defaultValue="emailAddress") String emailAddress){
        return accountRelatedServiceImpl.findUserByEmailAddress(emailAddress);
    }

    @RequestMapping(value = "/updateHeadByEmailAddress", method = RequestMethod.POST)
    @ResponseBody
    public Integer updateHeadByEmailAddress(@RequestParam(value = "emailAddress",defaultValue="emailAddress" )String emailAddress,
                                         @RequestParam(value = "headFlag",defaultValue = "1") String headFlag){
        return accountRelatedServiceImpl.updateHeadByEmailAddress(emailAddress,headFlag);
    }

    @RequestMapping(value = "/updateUserByEmailAddress", method = RequestMethod.POST)
    @ResponseBody
    public Integer updateUserByEmailAddress(@RequestParam(value = "emailAddress",defaultValue="emailAddress" )String emailAddress,
                                         @RequestParam(value = "userName",defaultValue="" )String userName,
                                         @RequestParam(value = "headUrl",defaultValue="1" )String headUrl,
                                         @RequestParam(value = "sex",defaultValue="1" )int sex,
                                         @RequestParam(value = "birthday",defaultValue = "birthday") Date birthday){
       return accountRelatedServiceImpl.updateUserByEmailAddress(emailAddress,userName,headUrl,sex,birthday);
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Integer updatePassword(@RequestParam(value = "emailAddress",defaultValue="emailAddress" )String emailAddress,
                               @RequestParam(value = "oldPassword", defaultValue = "") String oldPassword,
                               @RequestParam(value = "newPassword", defaultValue = "") String newPassword){
        return accountRelatedServiceImpl.updatePassword(emailAddress,oldPassword,newPassword);
    }





}
