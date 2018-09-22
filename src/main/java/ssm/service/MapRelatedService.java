package ssm.service;

import ssm.dto.MainInterfaceScenicSpotInfo;
import ssm.dto.ScenicSpotIntroduceInfo;
import ssm.dto.SearchScenicSpotInfo;
import ssm.dto.VoiceExplainInfo;

import java.util.List;

/**
 * 处理与地图有关的交互
 */
public interface MapRelatedService {

    /**
     * 根据经纬度返回最近的十个景点
     * @param longitude
     * @param dimension
     * @return
     */
    List<MainInterfaceScenicSpotInfo> findMainInterfaceScenicSpotInfo(float longitude, float dimension);


    ScenicSpotIntroduceInfo requestScenicSpotIntroduceInfo(int scenicSpotId);

    List<SearchScenicSpotInfo> searchScenicSpotByName(String name);

    List<SearchScenicSpotInfo> searchScenicSpotRandom();
}
