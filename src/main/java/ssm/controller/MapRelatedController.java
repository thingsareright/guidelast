package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.dto.MainInterfaceScenicSpotInfo;
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



}
