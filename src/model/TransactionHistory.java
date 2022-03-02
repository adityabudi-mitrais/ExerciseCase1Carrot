package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionHistory {

    private Date date;
    private String sender;
    private String receiver;
    private int point;

    public TransactionHistory(Date date, String sender, String receiver, int point) {
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
        this.point = point;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
        return "{" +
                "date=" + currentDate +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", point=" + point +
                '}';
    }
}
