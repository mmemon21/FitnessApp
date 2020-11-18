package com.example.fitnessproject3fall.model;

import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GroupChat {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int message_count;
    private int user_id;
    private String message;
    private int group_id;
    private String name;
    private String currentTime;


    public GroupChat(int message_count,int user_id, String message, int group_id, String name,String currentTime){
        this.message_count = message_count;
        this.user_id = user_id;
        this.message = message;
        this.group_id = group_id;
        this.name = name;
        this.currentTime=currentTime;
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
    public void setName(String name) { this.name = name; }
    public void setCurrentTime(String currentTime) { this.currentTime = currentTime; }

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
    public String getName(){return name;}
    public String getCurrentTime(){return currentTime;}

    @Override
    public String toString(){
        return "Message from " + name + " \n" + message + "\n"+currentTime;
    }
}