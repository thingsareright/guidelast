package ssm.entity;

import java.sql.Time;

public class Comment {

    private int commentId;
    private String userEmail;
    private int scenicSpotId;
    private int scenicAreaId;
    private String commentText;
    private Time commentTime;

    public Comment() {
    }

    public Comment(int commentId, String userEmail, int scenicSpotId, int scenicAreaId, String commentText, Time commentTime) {
        this.commentId = commentId;
        this.userEmail = userEmail;
        this.scenicSpotId = scenicSpotId;
        this.scenicAreaId = scenicAreaId;
        this.commentText = commentText;
        this.commentTime = commentTime;
    }

    public Comment(String userEmail, int scenicSpotId, int scenicAreaId, String commentText, Time commentTime) {
        this.userEmail = userEmail;
        this.scenicSpotId = scenicSpotId;
        this.scenicAreaId = scenicAreaId;
        this.commentText = commentText;
        this.commentTime = commentTime;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getScenicSpotId() {
        return scenicSpotId;
    }

    public void setScenicSpotId(int scenicSpotId) {
        this.scenicSpotId = scenicSpotId;
    }

    public int getScenicAreaId() {
        return scenicAreaId;
    }

    public void setScenicAreaId(int scenicAreaId) {
        this.scenicAreaId = scenicAreaId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Time getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Time commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userEmail='" + userEmail + '\'' +
                ", scenicSpotId=" + scenicSpotId +
                ", scenicAreaId=" + scenicAreaId +
                ", commentText='" + commentText + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
