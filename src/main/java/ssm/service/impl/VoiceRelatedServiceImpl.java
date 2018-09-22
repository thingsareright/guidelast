package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.ScenicSpotDao;
import ssm.dto.VoiceExplainInfo;
import ssm.service.VoiceRelatedService;

@Service
public class VoiceRelatedServiceImpl implements VoiceRelatedService {

    private static final String NOT_FOUND_SCENIC_SPOT_MESSAGE = "没有发现景点";

    @Autowired
    ScenicSpotDao scenicSpotDao;

    @Override
    public VoiceExplainInfo findVoiceExplain(float longitude, float dimension) {
        VoiceExplainInfo voiceExplainInfo = scenicSpotDao.findVoiceExplainInfoByLocation(longitude, dimension);
        return null==voiceExplainInfo?new VoiceExplainInfo(NOT_FOUND_SCENIC_SPOT_MESSAGE, NOT_FOUND_SCENIC_SPOT_MESSAGE):voiceExplainInfo;
    }

    /**
     * 语音助手，返回所需要讲解的景点的介绍
     * @param voiceWhat 需要讲解的景点的名称
     * @return 需要讲解的景点的介绍
     */
    @Override
    public String VoiceHelperDistinguish(String voiceWhat) {
        String resultIntroduce = scenicSpotDao.findVoiceHelperDistinguish(voiceWhat);
        return null==resultIntroduce?"没有发现您说的景点，请用普通话说出景点名称哦":resultIntroduce;
    }
}
