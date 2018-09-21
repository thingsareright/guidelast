package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.entity.User;

import java.util.List;

public interface UserDao {

    //ONLY TEST ORIGINALLY
    List<User> findARecord();

    /**
     * 查询邮箱地址是否已经存在于数据库中
     * @param emailAddress
     * @return
     */
    String existEmailAddress(@Param("emailAddress")String emailAddress);

}
