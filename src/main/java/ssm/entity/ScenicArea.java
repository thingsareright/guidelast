package ssm.entity;

public class ScenicArea {
    private int scenicareaid;
    private String scenicareaname;
    private String scenicareaintroduce;
    private float scenicarealongitude;
    private float scenicareadimension;
    private float scenicareascore;

    public ScenicArea() {
    }

    public ScenicArea(String scenicareaname, String scenicareaintroduce, float scenicarealongitude, float scenicareadimension, float scenicareascore) {
        this.scenicareaname = scenicareaname;
        this.scenicareaintroduce = scenicareaintroduce;
        this.scenicarealongitude = scenicarealongitude;
        this.scenicareadimension = scenicareadimension;
        this.scenicareascore = scenicareascore;
    }

    @Override
    public String toString() {
        return "ScenicArea{" +
                "scenicareaid=" + scenicareaid +
                ", scenicareaname='" + scenicareaname + '\'' +
                ", scenicareaintroduce='" + scenicareaintroduce + '\'' +
                ", scenicarealongitude=" + scenicarealongitude +
                ", scenicareadimension=" + scenicareadimension +
                ", scenicareascore=" + scenicareascore +
                '}';
    }

    public int getScenicareaid() {
        return scenicareaid;
    }

    public void setScenicareaid(int scenicareaid) {
        this.scenicareaid = scenicareaid;
    }

    public String getScenicareaname() {
        return scenicareaname;
    }

    public void setScenicareaname(String scenicareaname) {
        this.scenicareaname = scenicareaname;
    }

    public String getScenicareaintroduce() {
        return scenicareaintroduce;
    }

    public void setScenicareaintroduce(String scenicareaintroduce) {
        this.scenicareaintroduce = scenicareaintroduce;
    }

    public float getScenicarealongitude() {
        return scenicarealongitude;
    }

    public void setScenicarealongitude(float scenicarealongitude) {
        this.scenicarealongitude = scenicarealongitude;
    }

    public float getScenicareadimension() {
        return scenicareadimension;
    }

    public void setScenicareadimension(float scenicareadimension) {
        this.scenicareadimension = scenicareadimension;
    }

    public float getScenicareascore() {
        return scenicareascore;
    }

    public void setScenicareascore(float scenicareascore) {
        this.scenicareascore = scenicareascore;
    }
}
