package ssm.service;

import ssm.dto.VoiceExplainInfo;

public interface VoiceRelatedService {
    VoiceExplainInfo findVoiceExplain(float longitude, float dimension);

    String VoiceHelperDistinguish(String voiceWhat);
}
