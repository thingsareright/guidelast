package ssm.entity;

import java.sql.Time;

public class ScenicSpot {

    private int scenicSpotId;
    private String scenicSpotName;
    private String scenicSpotIntroduce;
    private float scenicSpotLongitude;
    private float scenicSpotDimension;
    private float scenicSpotScore;
    private int scenicSpotCommentNum;
    private Time scenicSpotStarttime;
    private Time scenicSpotEndtime;
    private int scenicAreaId;

    public ScenicSpot() {
    }

    public ScenicSpot(String scenicSpotName, String scenicSpotIntroduce, float scenicSpotLongitude, float scenicSpotDimension, float scenicSpotScore, int scenicSpotCommentNum, Time scenicSpotStarttime, Time scenicSpotEndtime, int scenicAreaId) {
        this.scenicSpotName = scenicSpotName;
        this.scenicSpotIntroduce = scenicSpotIntroduce;
        this.scenicSpotLongitude = scenicSpotLongitude;
        this.scenicSpotDimension = scenicSpotDimension;
        this.scenicSpotScore = scenicSpotScore;
        this.scenicSpotCommentNum = scenicSpotCommentNum;
        this.scenicSpotStarttime = scenicSpotStarttime;
        this.scenicSpotEndtime = scenicSpotEndtime;
        this.scenicAreaId = scenicAreaId;
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

    public String getScenicSpotIntroduce() {
        return scenicSpotIntroduce;
    }

    public void setScenicSpotIntroduce(String scenicSpotIntroduce) {
        this.scenicSpotIntroduce = scenicSpotIntroduce;
    }

    public float getScenicSpotLongitude() {
        return scenicSpotLongitude;
    }

    public void setScenicSpotLongitude(float scenicSpotLongitude) {
        this.scenicSpotLongitude = scenicSpotLongitude;
    }

    public float getScenicSpotDimension() {
        return scenicSpotDimension;
    }

    public void setScenicSpotDimension(float scenicSpotDimension) {
        this.scenicSpotDimension = scenicSpotDimension;
    }

    public float getScenicSpotScore() {
        return scenicSpotScore;
    }

    public void setScenicSpotScore(float scenicSpotScore) {
        this.scenicSpotScore = scenicSpotScore;
    }

    public int getScenicSpotCommentNum() {
        return scenicSpotCommentNum;
    }

    public void setScenicSpotCommentNum(int scenicSpotCommentNum) {
        this.scenicSpotCommentNum = scenicSpotCommentNum;
    }

    public Time getScenicSpotStarttime() {
        return scenicSpotStarttime;
    }

    public void setScenicSpotStarttime(Time scenicSpotStarttime) {
        this.scenicSpotStarttime = scenicSpotStarttime;
    }

    public Time getScenicSpotEndtime() {
        return scenicSpotEndtime;
    }

    public void setScenicSpotEndtime(Time scenicSpotEndtime) {
        this.scenicSpotEndtime = scenicSpotEndtime;
    }

    public int getScenicAreaId() {
        return scenicAreaId;
    }

    public void setScenicAreaId(int scenicAreaId) {
        this.scenicAreaId = scenicAreaId;
    }

    @Override
    public String toString() {
        return "ScenicSpot{" +
                "scenicSpotId=" + scenicSpotId +
                ", scenicSpotName='" + scenicSpotName + '\'' +
                ", scenicSpotIntroduce='" + scenicSpotIntroduce + '\'' +
                ", scenicSpotLongitude=" + scenicSpotLongitude +
                ", scenicSpotDimension=" + scenicSpotDimension +
                ", scenicSpotScore=" + scenicSpotScore +
                ", scenicSpotCommentNum=" + scenicSpotCommentNum +
                ", scenicSpotStarttime=" + scenicSpotStarttime +
                ", scenicSpotEndtime=" + scenicSpotEndtime +
                ", scenicAreaId=" + scenicAreaId +
                '}';
    }

}
