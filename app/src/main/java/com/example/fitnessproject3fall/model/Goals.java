package com.example.fitnessproject3fall.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity
public class Goals {
    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int count;
    @NonNull
    private String date;
    private int group_id; // Foreign Key
    private String goals_description;

    public Goals(int count, int group_id, String goals_description,String date){
        this.count = count;
        this.group_id = group_id;
        this.goals_description= goals_description;
        this.date = date;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setGoals_description(String goals_description) {
        this.goals_description = goals_description;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public int getGroup_id() {
        return group_id;
    }

    public String getGoals_description() {
        return goals_description;
    }

    @NonNull
    public String getDate() {
        return date;
    }
    @Override
    public String toString(){
        return "Date: " + date + "\n"
                + "Goal: " + goals_description;
    }
}