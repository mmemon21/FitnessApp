package com.example.fitnessproject3fall.model;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface FitnessDAO {
    @Query("select * from User")
    List<User> getAllUser();

    @Query("select * from Coach")
    List<Coach> getAllCoach();

    @Query("select * from DirectMsg")
    List<DirectMsg> getAllMessages();

    @Query("select * from DirectMsg where group_id =:group_id")
    List<DirectMsg> searchMsg(int group_id);

    @Query("select * from Goals where date =:date")
    Goals searchGoal(String date);

    @Query("select * from User where user_id =:user_id")
    User searchUser(int user_id);
    @Insert
    void addUser(User user);
    @Insert
    void addMsg(DirectMsg msg);
    @Insert
    void addCoach(Coach msg);
    @Insert
    void addGoals(Goals goal);
    @Insert
    void addLinks(Links link);
    @Insert
    void addVideos(Videos video);

}