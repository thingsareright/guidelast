package ssm.service;

import ssm.dto.*;

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

    List<SearchScenicSpotInfo> searchScenicSpotByName(String name, int start, int length);

    List<SearchScenicSpotInfo> searchScenicSpotRandom();

    List<SearchScenicSpotInfo> searchScenicSpotsByAreaId(int areaId, int start, int length);

    List<HotMapInfoSend> getHotMapPointsService(int views);
}
