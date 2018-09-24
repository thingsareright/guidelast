package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.entity.Picture;

import java.util.List;

public interface PictureDao {

    //ONLY TEST ORIGINALLY
    List<Picture> findARecord();

    String findFirstPictureByScenicSpotId(@Param("scenicSpotId") int scenicSpotId);

    Integer insertPictureUrl(@Param("url") String url);
}
