package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.entity.User;

import java.util.Date;
import java.util.List;

public interface UserDao {

    //ONLY TEST ORIGINALLY
    List<User> findARecord();

    /**
     * 查询邮箱地址是否已经存在于数据库中
     * @param emailAddress
     * @return
     */
    String existEmailAddress(@Param("emailAddress") String emailAddress);

    Integer addAUser(@Param("newUser") User user);

    String findPasswordByEmailAddress(@Param("emailAddress") String emailAddress);

    User findARecordByEmailAndPassword(@Param("emailAddress") String emailaAddress, @Param("password") String password);

    Integer updateHeadByEmailAddressAndPassword(@Param("emailAddress") String emailAddress, @Param("password") String password, @Param("headFlag") String headFlag);

    Integer updateUserByEmailAddressAndPassword(@Param("emailAddress") String emailAddress,
                                                @Param("password") String password,
                                                @Param("userName") String userName,
                                                @Param("userHeadPictureUrl") String userHeadPictureUrl,
                                                @Param("userSex") int userSex,
                                                @Param("userBirthday") Date userBirthday);

    Integer updatePassword(@Param("emailAddress") String emailAddress,
                           @Param("newPassword") String newPassword);

    String checkOldPassword(@Param("emailAddress") String emailAddress,
                            @Param("oldPassword") String oldPassword);
}
