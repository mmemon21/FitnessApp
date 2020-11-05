package com.example.fitnessproject3fall.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DirectMsg {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int message_count;
    private int user_id;
    private String message;
    private int group_id;

    public DirectMsg(int message_count,int user_id, String message, int group_id){
        this.message_count = message_count;
        this.user_id = user_id;
        this.message = message;
        this.group_id = group_id;
    }

    public void setMessage_count(int message_count){this.message_count =message_count;}
    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGroup_id() {
        return group_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public String getMessage(){
        return message;
    }
    public int getMessage_count() {
        return message_count;
    }

    @Override
    public String toString(){
        return "Message: " + message;
    }
}