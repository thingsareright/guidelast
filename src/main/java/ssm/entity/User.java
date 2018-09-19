package ssm.entity;

public class User {

    private String userTel;
    private String userPassword;
    private String userName;
    private String userPictureUrl;

    public User() {
    }

    public User(String userTel, String userPassword, String userName, String userPictureUrl) {
        this.userTel = userTel;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPictureUrl = userPictureUrl;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPictureUrl() {
        return userPictureUrl;
    }

    public void setUserPictureUrl(String userPictureUrl) {
        this.userPictureUrl = userPictureUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "userTel='" + userTel + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userPictureUrl='" + userPictureUrl + '\'' +
                '}';
    }

}
