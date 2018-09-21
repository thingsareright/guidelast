package ssm.dto;

import ssm.entity.User;

import java.sql.Date;

public class UserInfoRegister extends User {
    private String token;   //邮箱验证码

    public UserInfoRegister(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfoRegister(String userEmail, String userPassword, String userName, String userPictureUrl, int userSex, Date userBirthday, String token) {
        super(userEmail, userPassword, userName, userPictureUrl, userSex, userBirthday);
        this.token = token;
    }
}
