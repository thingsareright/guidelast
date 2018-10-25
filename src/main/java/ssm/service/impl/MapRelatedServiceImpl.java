package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ssm.dao.PictureDao;
import ssm.dao.ScenicSpotDao;
import ssm.dto.*;
import ssm.entity.ScenicSpot;
import ssm.service.MapRelatedService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MapRelatedServiceImpl implements MapRelatedService {



    @Autowired
    ScenicSpotDao scenicSpotDao;
    @Autowired
    PictureDao pictureDao;
    @Resource
    private RedisTemplate redisTemplate;

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
     * 按名称相似度查找景点,注意每个景点只返回一条
     */
    @Override
    public List<SearchScenicSpotInfo> searchScenicSpotByName(String name, int start, int length) {
        List<SearchScenicSpotInfo> searchScenicSpotInfos = scenicSpotDao.searchScenicSpotByName(name, start, length);
        Iterator<SearchScenicSpotInfo> iterators = searchScenicSpotInfos.iterator();
        SearchScenicSpotInfo searchScenicSpotInfo = null;
        if (iterators.hasNext()){
            searchScenicSpotInfo = iterators.next();
        }
        while (iterators.hasNext()) {
            SearchScenicSpotInfo searchScenicSpot = iterators.next();
            if (searchScenicSpot.getScenicSpotId() == (searchScenicSpotInfo.getScenicSpotId())){
                iterators.remove();
            } else {
                searchScenicSpotInfo = searchScenicSpot;
            }
        }
        return searchScenicSpotInfos;
    }

    /**
     * 随机选取十个景点
     * @return
     */
    @Override
    public List<SearchScenicSpotInfo> searchScenicSpotRandom() {
        return scenicSpotDao.searchScenicSpotRandom();
    }

    /**
     * 选取某景点从第start（从0开始）开始的length条记录
     * @param areaId
     * @param start
     * @param length
     * @return
     */
    @Override
    public List<SearchScenicSpotInfo> searchScenicSpotsByAreaId(int areaId, int start, int length) {
        List<SearchScenicSpotInfo> searchScenicSpotInfos =  scenicSpotDao.searchScenicSpotsByArea(areaId, start, length);
        for (SearchScenicSpotInfo searchScenicSpotInfo :
                searchScenicSpotInfos) {
            searchScenicSpotInfo.setPictureUrl(pictureDao.findFirstPictureByScenicSpotId(searchScenicSpotInfo.getScenicSpotId()));
        }
        return searchScenicSpotInfos;
    }


    /**
     * 返回热力图所需信息
     * @param views 阈值
     * @return
     */
    @Override
   public List<HotMapInfoSend> getHotMapPointsService(int views){
        List<HotMapInfo> hotMapInfos = scenicSpotDao.getHotMapPointsDao(views);
        //为了方便controller层根据类里成员的名字转换为JSON，我们需要转换对象
        List<HotMapInfoSend> hotMapInfoSends = new ArrayList<>();
        for (HotMapInfo hotMapInfo :
                hotMapInfos) {
            hotMapInfoSends.add(new HotMapInfoSend(hotMapInfo.getScenicSpotDimension(), hotMapInfo.getScenicSpotLongitude(), hotMapInfo.getScenicSpotNum()));
        }
        return hotMapInfoSends;
   }
}
