package ssm.dto;

public class HotMapInfoSend {

    private float lat;
    private float lng;
    private int views;

    public HotMapInfoSend() {
    }

    public HotMapInfoSend(float lat, float lng, int views) {
        this.lat = lat;
        this.lng = lng;
        this.views = views;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "HotMapInfoSend{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", views=" + views +
                '}';
    }
}
