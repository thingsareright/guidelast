package ssm.dto;

/**
 * 语音讲解信息
 */
public class VoiceExplainInfo {

    private String scenicSpotName;
    private String scenicSpotIntroduce;

    public VoiceExplainInfo() {
    }

    public VoiceExplainInfo(String scenicSpotName, String scenicSpotIntroduce) {
        this.scenicSpotName = scenicSpotName;
        this.scenicSpotIntroduce = scenicSpotIntroduce;
    }

    public String getScenicSpotName() {
        return scenicSpotName;
    }

    public void setScenicSpotName(String scenicSpotName) {
        this.scenicSpotName = scenicSpotName;
    }

    public String getScenicSpotIntroduce() {
        return scenicSpotIntroduce;
    }

    public void setScenicSpotIntroduce(String scenicSpotIntroduce) {
        this.scenicSpotIntroduce = scenicSpotIntroduce;
    }

    @Override
    public String toString() {
        return "VoiceExplainInfo{" +
                "scenicSpotName='" + scenicSpotName + '\'' +
                ", scenicSpotIntroduce='" + scenicSpotIntroduce + '\'' +
                '}';
    }
}
