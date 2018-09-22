package ssm.dto;

public class MainInterfaceScenicSpotInfo {

    private int scenicSpotId;
    private String scenicSpotName;
    private String pictureUrl;

    public MainInterfaceScenicSpotInfo() {
    }

    public MainInterfaceScenicSpotInfo(int scenicSpotId, String scenicSpotName, String pictureUrl) {
        this.scenicSpotId = scenicSpotId;
        this.scenicSpotName = scenicSpotName;
        this.pictureUrl = pictureUrl;
    }

    public int getScenicSpotId() {
        return scenicSpotId;
    }

    public void setScenicSpotId(int scenicSpotId) {
        this.scenicSpotId = scenicSpotId;
    }

    public String getScenicSpotName() {
        return scenicSpotName;
    }

    public void setScenicSpotName(String scenicSpotName) {
        this.scenicSpotName = scenicSpotName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "MainInterfaceScenicSpotInfo{" +
                "scenicSpotId=" + scenicSpotId +
                ", scenicSpotName=" + scenicSpotName +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
