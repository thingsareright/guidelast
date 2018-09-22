package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.PictureDao;
import ssm.dao.ScenicSpotDao;
import ssm.dto.MainInterfaceScenicSpotInfo;
import ssm.dto.ScenicSpotIntroduceInfo;
import ssm.dto.SearchScenicSpotInfo;
import ssm.dto.VoiceExplainInfo;
import ssm.entity.ScenicSpot;
import ssm.service.MapRelatedService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapRelatedServiceImpl implements MapRelatedService {


    @Autowired
    ScenicSpotDao scenicSpotDao;
    @Autowired
    PictureDao pictureDao;

    @Override
    public List<MainInterfaceScenicSpotInfo> findMainInterfaceScenicSpotInfo(float longitude, float dimension) {
        //第一步，先取得所有的景点
        List<ScenicSpot> scenicSpots = scenicSpotDao.findMostNearScenicSpot(longitude, dimension);
        List<MainInterfaceScenicSpotInfo> mainInterfaceScenicSpotInfos = new ArrayList<>();
        //第二步，再为每个地点选一张图片
        for (ScenicSpot scenicSpot :
                scenicSpots) {
            String pictureUrl = pictureDao.findFirstPictureByScenicSpotId(scenicSpot.getScenicSpotId());
            MainInterfaceScenicSpotInfo mainInterfaceScenicSpotInfo = new MainInterfaceScenicSpotInfo(scenicSpot.getScenicSpotId(),scenicSpot.getScenicSpotName(),pictureUrl);
            mainInterfaceScenicSpotInfos.add(mainInterfaceScenicSpotInfo);
        }
        return mainInterfaceScenicSpotInfos;
    }

    /**
     * 获取单个景点的信息
     * @param scenicSpotId 单个景点的ID
     * @return
     */
    @Override
    public ScenicSpotIntroduceInfo requestScenicSpotIntroduceInfo(int scenicSpotId) {
        return scenicSpotDao.findScenicSpotIntroduceInfo(scenicSpotId);
    }

    /**
     * 按名称相似度查找最多十个景点
     */
    @Override
    public List<SearchScenicSpotInfo> searchScenicSpotByName(String name) {
        return scenicSpotDao.searchScenicSpotByName(name);
    }

    /**
     * 随机选取十个景点
     * @return
     */
    @Override
    public List<SearchScenicSpotInfo> searchScenicSpotRandom() {
        return scenicSpotDao.searchScenicSpotRandom();
    }

}
