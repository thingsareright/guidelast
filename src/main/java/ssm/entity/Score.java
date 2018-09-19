package ssm.entity;

public class Score {

    private int scoreId;
    private int scenicAreaId;
    private int scenicSpotId;
    private String userTel;
    private float score;

    public Score() {
    }

    public Score(int scenicAreaId, int scenicSpotId, String userTel, float score) {
        this.scenicAreaId = scenicAreaId;
        this.scenicSpotId = scenicSpotId;
        this.userTel = userTel;
        this.score = score;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
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

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", scenicAreaId=" + scenicAreaId +
                ", scenicSpotId=" + scenicSpotId +
                ", userTel='" + userTel + '\'' +
                ", score=" + score +
                '}';
    }

}
