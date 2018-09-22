package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.dto.VoiceExplainInfo;
import ssm.entity.ScenicSpot;

import java.util.List;

public interface ScenicSpotDao {

    //ONLY TEST ORIGINALLY
    List<ScenicSpot> findARecord();

    /**
     * 选取距此经纬度距离最近的十个地点
     * @param longitude
     * @param dimension
     * @return
     */
    List<ScenicSpot> findMostNearScenicSpot(@Param("longitude") float longitude, @Param("dimension") float dimension);

    /** 语音讲解
     * 发{位置信息 -- 经纬度} -- 收{景点名称，景点介绍}
     * @param longitude
     * @param dimension
     * @return
     */
    VoiceExplainInfo findVoiceExplainInfoByLocation(@Param("longitude") float longitude, @Param("dimension") float dimension);

    /**
     * 语音助手，获取匹配地点
     * @param helper
     * @return
     */
    String findVoiceHelperDistinguish(@Param("helper") String helper);

}
