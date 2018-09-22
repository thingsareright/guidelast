package ssm.dto;

/**
 * 传递景点介绍信息
 */
public class ScenicSpotIntroduceInfo {

    private int scenicSpotId;
    private String pictureUrl;
    private String scenicSpotName;
    private String scenicSpotIntroduce;

    public ScenicSpotIntroduceInfo() {
    }

    public ScenicSpotIntroduceInfo(int scenicSpotId, String pictureUrl, String scenicSpotName, String scenicSpotIntroduce) {
        this.scenicSpotId = scenicSpotId;
        this.pictureUrl = pictureUrl;
        this.scenicSpotName = scenicSpotName;
        this.scenicSpotIntroduce = scenicSpotIntroduce;
    }

    public int getScenicSpotId() {
        return scenicSpotId;
    }

    public void setScenicSpotId(int scenicSpotId) {
        this.scenicSpotId = scenicSpotId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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
        return "ScenicSpotIntroduceInfo{" +
                "scenicSpotId=" + scenicSpotId +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", scenicSpotName='" + scenicSpotName + '\'' +
                ", scenicSpotIntroduce='" + scenicSpotIntroduce + '\'' +
                '}';
    }
}
