package ssm.dto;

/**
 * 与热力图有关的信息
 */
public class HotMapInfo {

    private float scenicSpotDimension; //纬度
    private float scenicSpotLongitude; //经度
    private int scenicSpotNum;

    public HotMapInfo() {
    }

    public float getScenicSpotDimension() {
        return scenicSpotDimension;
    }

    public void setScenicSpotDimension(float scenicSpotDimension) {
        this.scenicSpotDimension = scenicSpotDimension;
    }

    public float getScenicSpotLongitude() {
        return scenicSpotLongitude;
    }

    public void setScenicSpotLongitude(float scenicSpotLongitude) {
        this.scenicSpotLongitude = scenicSpotLongitude;
    }

    public int getScenicSpotNum() {
        return scenicSpotNum;
    }

    public void setScenicSpotNum(int scenicSpotNum) {
        this.scenicSpotNum = scenicSpotNum;
    }

    @Override
    public String toString() {
        return "HotMapInfo{" +
                "scenicSpotDimension=" + scenicSpotDimension +
                ", scenicSpotLongitude=" + scenicSpotLongitude +
                ", scenicSpotNum=" + scenicSpotNum +
                '}';
    }
}
