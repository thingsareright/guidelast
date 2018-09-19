package ssm.entity;

public class Video {

    private int videoId;
    private int scenicAreaId;
    private int scenicSpotId;
    private String videoUri;

    public Video() {
    }

    public Video(int videoId, int scenicAreaId, int scenicSpotId, String videoUri) {
        this.videoId = videoId;
        this.scenicAreaId = scenicAreaId;
        this.scenicSpotId = scenicSpotId;
        this.videoUri = videoUri;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
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

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", scenicAreaId=" + scenicAreaId +
                ", scenicSpotId=" + scenicSpotId +
                ", videoUri='" + videoUri + '\'' +
                '}';
    }
}
