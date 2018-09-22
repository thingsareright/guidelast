package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.dto.VoiceExplainInfo;
import ssm.service.VoiceRelatedService;

@Controller
@RequestMapping("/voice")
public class VoiceRelatedController {


    @Autowired
    VoiceRelatedService voiceRelatedService;

    /**
     * 处理语音讲解中景点信息的信息获取需求
     * @return
     */
    @RequestMapping(value = "/requestVoiceExplain", method = RequestMethod.GET)
    @ResponseBody
    public VoiceExplainInfo requestVoiceExplain(
            @RequestParam("longitude") float longitude,
            @RequestParam("dimension") float dimension
    ){
        return voiceRelatedService.findVoiceExplain(longitude, dimension);
    }

    /**
     * 支持语音讲解中景点信息获取需求
     * @param voiceHelper
     * @return
     */
    @RequestMapping(value = "/requestIntroduceVoiceHelper", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object requestIntroduceVoiceHelper(@RequestParam("voiceHelper") String voiceHelper) {
        return voiceRelatedService.VoiceHelperDistinguish(voiceHelper);
    }
}
