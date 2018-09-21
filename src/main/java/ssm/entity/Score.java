package ssm.entity;

public class Score {

    private int scoreId;
    private int scenicAreaId;
    private int scenicSpotId;
    private String userEmail;
    private float score;

    public Score() {
    }

    public Score(int scoreId, int scenicAreaId, int scenicSpotId, String userEmail, float score) {
        this.scoreId = scoreId;
        this.scenicAreaId = scenicAreaId;
        this.scenicSpotId = scenicSpotId;
        this.userEmail = userEmail;
        this.score = score;
    }

    public Score(int scenicAreaId, int scenicSpotId, String userEmail, float score) {
        this.scenicAreaId = scenicAreaId;
        this.scenicSpotId = scenicSpotId;
        this.userEmail = userEmail;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
                ", userEmail='" + userEmail + '\'' +
                ", score=" + score +
                '}';
    }
}
