package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.dto.*;
import ssm.service.MapRelatedService;

import java.util.List;

/**
 * 处理与地理信息有关的请求
 */
@Controller
@RequestMapping("/map")
public class MapRelatedController {

    @Autowired
    MapRelatedService mapRelatedService;

    /**
     * 主界面获取景点列表的业务支持
     * @param longitude
     * @param dimension
     * @return
     */
    @RequestMapping(value = "/requestMainInterfaceScenicSpotInfos", method = RequestMethod.GET)
    @ResponseBody
    public List<MainInterfaceScenicSpotInfo> requestMainInterfaceScenicSpotInfos(
            @RequestParam("longitude") float longitude,
            @RequestParam("dimension") float dimension
    ){
        return mapRelatedService.findMainInterfaceScenicSpotInfo(longitude, dimension);
    }

    /**
     * 获取单个景点的信息, TODO 可能空值时有点问题
     * @param scenicSpotId
     * @return
     */
    @RequestMapping(value = "requestScenicSpotIntroduceInfo", method = RequestMethod.GET)
    @ResponseBody
    public ScenicSpotIntroduceInfo requestScenicSpotIntroduceInfo(
            @RequestParam(value = "scenicSpotId", defaultValue = "1") int scenicSpotId
    ) {
        return mapRelatedService.requestScenicSpotIntroduceInfo(scenicSpotId);
    }

    /**
     * 获取与某个名字相似度最高的十个景点
     * @param name
     * @return
     */
    @RequestMapping(value = "requestSearchScenicSpotByName", method = RequestMethod.GET)
    @ResponseBody
    public List<SearchScenicSpotInfo> requestSearchScenicSpotByName(
            @RequestParam(value = "name", defaultValue = "图书馆") String name,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "len", defaultValue = "10") int length
    ) {
        return mapRelatedService.searchScenicSpotByName(name, start, length);
    }

    /**
     * 随机选取十个景点
     * @return
     */
    @RequestMapping(value = "requestSearchScenicSpotRandom", method = RequestMethod.GET)
    @ResponseBody
    public List<SearchScenicSpotInfo> requestSearchScenicSpotRandom() {
        return mapRelatedService.searchScenicSpotRandom();
    }

    /**
     * 返回以JSON格式的，对应景区ID为areaId的，从第start条记录开始的length条记录
     * @param areaId  景区的ID
     * @param start   从第start条记录开始
     * @param length    返回记录的数目
     * @return JSON格式串
     */
    @RequestMapping(value = "/searchScenicSpotsByAreaId", method = RequestMethod.GET)
    @ResponseBody
    public List<SearchScenicSpotInfo> searchScenicSpotsByAreaId(
            @RequestParam("areaId") int areaId,
            @RequestParam("start") int start,
            @RequestParam("length") int length
    ) {
        return mapRelatedService.searchScenicSpotsByAreaId(areaId, start, length);
    }

    /**
     * 用于获取热力图的信息
     * @param views 多少人以上才算是热力图，是个阈值，目前暂定为10
     * @return
     */
    @RequestMapping(value = "/getHotMapPoints")
    @ResponseBody
    public List<HotMapInfoSend> getHotMapPoints(
            @RequestParam(value = "views", defaultValue = "10") int views){
        return mapRelatedService.getHotMapPointsService(views);
    }
}
