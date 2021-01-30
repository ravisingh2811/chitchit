package com.example.chitchat.Models;

public class MessageModel {

    String uId , message ;
    long timestamp;

    public MessageModel(String uId ,String message , Long timestamp ) {
        this.uId = uId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public MessageModel(String uId, String message) {

        this.uId = uId;
        this.message = message;
    }
    public MessageModel(){}


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
