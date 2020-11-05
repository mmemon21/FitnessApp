package com.example.fitnessproject3fall.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity
public class User {
    @PrimaryKey
    private int user_id; // Primary Key
    private String first_name;
    private String last_name;
    private int age;
    private String profile_url;
    private String bio;
    private String username;
    private String password;
    @NonNull
    private int group_id; // Foreign Key

    //private ImageView profile_url;  if we have time we will implement images

    public User(int user_id, String first_name, String last_name, int age, String profile_url, String bio, String username,
                String password, int group_id){
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.profile_url = profile_url;
        this.bio = bio;
        this.username = username;
        this.password = password;
        this.group_id = group_id;
    }
    @NonNull
    public void setUser_id(int user_id) {this.user_id = user_id; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }
    public void setAge(int age) { this.age = age; }
    public void setProfile_url(String profile_url) { this.profile_url = profile_url; }
    public void setBio(String bio) { this.bio = bio; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    @NonNull
    public void setGroup_id(int group_id) { this.group_id = group_id; }

    public int getUser_id() { return user_id; }
    public String getFirst_name(){return first_name;}
    public String getLast_name() { return last_name; }
    public int getAge() { return age; }
    public String getProfile_url() { return profile_url; }
    public String getBio() { return bio; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getGroup_id() { return group_id; }

    //toString
    @Override
    public String toString(){
        return "Username: " + username + "\n"+
                "First & Last name: " + first_name + " " + last_name;
    }
}
