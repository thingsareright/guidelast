package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.dto.MainInterfaceScenicSpotInfo;
import ssm.dto.ScenicSpotIntroduceInfo;
import ssm.dto.SearchScenicSpotInfo;
import ssm.dto.VoiceExplainInfo;
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
            @RequestParam(value = "name", defaultValue = "图书馆") String name
    ) {
        return mapRelatedService.searchScenicSpotByName(name);
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


}
