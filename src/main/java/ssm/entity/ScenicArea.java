package ssm.entity;

public class ScenicArea {
    private int scenicAreaId;
    private String scenicAreaName;
    private String scenicAreaIntroduce;
    private float scenicAreaLongitude;
    private float scenicAreaDimension;
    private float scenicAreaScore;

    public ScenicArea() {
    }

    public ScenicArea(String scenicAreaName, String scenicAreaIntroduce, float scenicAreaLongitude, float scenicAreaDimension, float scenicAreaScore) {
        this.scenicAreaName = scenicAreaName;
        this.scenicAreaIntroduce = scenicAreaIntroduce;
        this.scenicAreaLongitude = scenicAreaLongitude;
        this.scenicAreaDimension = scenicAreaDimension;
        this.scenicAreaScore = scenicAreaScore;
    }

    public int getScenicAreaId() {
        return scenicAreaId;
    }

    public void setScenicAreaId(int scenicAreaId) {
        this.scenicAreaId = scenicAreaId;
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

    public float getScenicAreaLongitude() {
        return scenicAreaLongitude;
    }

    public void setScenicAreaLongitude(float scenicAreaLongitude) {
        this.scenicAreaLongitude = scenicAreaLongitude;
    }

    public float getScenicAreaDimension() {
        return scenicAreaDimension;
    }

    public void setScenicAreaDimension(float scenicAreaDimension) {
        this.scenicAreaDimension = scenicAreaDimension;
    }

    public float getScenicAreaScore() {
        return scenicAreaScore;
    }

    public void setScenicAreaScore(float scenicAreaScore) {
        this.scenicAreaScore = scenicAreaScore;
    }

    @Override
    public String toString() {
        return "ScenicArea{" +
                "scenicAreaId=" + scenicAreaId +
                ", scenicAreaName='" + scenicAreaName + '\'' +
                ", scenicAreaIntroduce='" + scenicAreaIntroduce + '\'' +
                ", scenicAreaLongitude=" + scenicAreaLongitude +
                ", scenicAreaDimension=" + scenicAreaDimension +
                ", scenicAreaScore=" + scenicAreaScore +
                '}';
    }
}
