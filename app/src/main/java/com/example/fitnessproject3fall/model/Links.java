package com.example.fitnessproject3fall.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Links {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int count;//Primary Key
    private int group_id; // Foreign Key
    private String link_url;//may be edited
    private String description;
    private String category;


    public Links(int count ,int group_id, String link_url,String description, String category) {
        this.count = count;
        this.group_id = group_id;
        this.link_url = link_url;
        this.description = description;
        this.category = category;
    }
    public void setCount(int count){this.count= count;}
    public void setGroup_id(int group_id){this.group_id = group_id;}
    public void setVideo_url(String link_url){this.link_url = link_url;}
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public int getGroup_id(){return group_id;}
    public int getCount() { return count;}
    public String getLink_url(){return link_url;}

    @Override
    public String toString(){
        return "Description:" + description + "\n"
                  +"Category: "+ category;
    }
}