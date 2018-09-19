package ssm.entity;

public class Picture {

    private int pictureId;
    private int scenicAreaId;
    private int scenicSpotId;
    private String pictureUrl;

    public Picture() {
    }

    public Picture(int scenicAreaId, int scenicSpotId, String pictureUrl) {
        this.scenicAreaId = scenicAreaId;
        this.scenicSpotId = scenicSpotId;
        this.pictureUrl = pictureUrl;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getScenicAreaId() {
        return scenicAreaId;
    }

    public void setScenicAreaId(int scenicAreaId) {
        this.scenicAreaId = scenicAreaId;
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

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId=" + pictureId +
                ", scenicAreaId=" + scenicAreaId +
                ", scenicSpotId=" + scenicSpotId +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
