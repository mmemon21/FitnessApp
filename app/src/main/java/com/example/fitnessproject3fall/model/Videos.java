package com.example.fitnessproject3fall.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Videos {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int count;//Primary Key
    private int group_id; // Foreign Key
    private String video_url;//may be edited


    public Videos(int count ,int group_id, String video_url) {
        this.count = count;
        this.group_id = group_id;
        this.video_url = video_url;
    }
    public void setCount(int count){this.count= count;}
    public void setGroup_id(int group_id){this.group_id = group_id;}
    public void setVideo_url(String video_url){this.video_url = video_url;}
    public int getGroup_id(){return group_id;}
    public int getCount() { return count;}

    public String getVideo_url(){return video_url;}

}
