package ssm.entity;

import java.sql.Timestamp;

public class Card {
    private int cardId;
    private String storeName;
    private float storeDiscount;
    private Timestamp starttime;
    private Timestamp endtime;

    public Card() {
    }

    public Card(String storeName, float storeDiscount, Timestamp starttime, Timestamp endtime) {
        this.storeName = storeName;
        this.storeDiscount = storeDiscount;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public float getStoreDiscount() {
        return storeDiscount;
    }

    public void setStoreDiscount(float storeDiscount) {
        this.storeDiscount = storeDiscount;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", storeName='" + storeName + '\'' +
                ", storeDiscount=" + storeDiscount +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }
}
