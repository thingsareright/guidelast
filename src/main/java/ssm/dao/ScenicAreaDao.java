package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.entity.ScenicArea;

import java.util.List;

public interface ScenicAreaDao {

    //ONLY TEST ORIGINALLY
    List<ScenicArea> findARecord();

    Integer insertScenicAreaRecord(@Param("scenicArea") ScenicArea scenicArea);
}
