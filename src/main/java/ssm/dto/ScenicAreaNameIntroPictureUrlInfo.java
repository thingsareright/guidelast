package ssm.dto;

public class ScenicAreaNameIntroPictureUrlInfo {

    private String scenicAreaName;    //景区名
    private String scenicAreaIntroduce;
    private String pictureUrl;

    public ScenicAreaNameIntroPictureUrlInfo() {
    }

    public ScenicAreaNameIntroPictureUrlInfo(String scenicAreaName, String scenicAreaIntroduce, String pictureUrl) {
        this.scenicAreaName = scenicAreaName;
        this.scenicAreaIntroduce = scenicAreaIntroduce;
        this.pictureUrl = pictureUrl;
    }

    public String getScenicAreaName() {
        return scenicAreaName;
    }

    public void setScenicAreaName(String scenicAreaName) {
        this.scenicAreaName = scenicAreaName;
    }

    public String getScenicAreaIntroduce() {
        return scenicAreaIntroduce;
    }

    public void setScenicAreaIntroduce(String scenicAreaIntroduce) {
        this.scenicAreaIntroduce = scenicAreaIntroduce;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "ScenicAreaNameIntroPictureUrlInfo{" +
                "scenicAreaName='" + scenicAreaName + '\'' +
                ", scenicAreaIntroduce='" + scenicAreaIntroduce + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
