package ssm.service;

public interface AccountedRelatedService {
    int registerWithEmailAddress(String emailAddress, String token, String name, String sex, String birthday,
                                 String password, String confirmPassword, String userPictureUrl);
}
