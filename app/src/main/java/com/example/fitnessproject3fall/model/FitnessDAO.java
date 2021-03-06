package com.example.fitnessproject3fall.model;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface FitnessDAO {
    @Query("select * from User")//First Get all Objects in DB
    List<User> getAllUser();

    @Query("select * from Coach")
    List<Coach> getAllCoach();

    @Query("select * from DirectMsg")
    List<DirectMsg> getAllMessages();

    @Query("select * from GroupChat")
    List<GroupChat> getAllGroupMsg();

    @Query("select * from Goals")
    List<Goals> getAllGoals();

    @Query("select * from Links where group_id=:group_id")
    List<Links> searchLinks(int group_id);

    @Query("select * from Links")
    List<Links> getAllNutrition();

    @Query("select * from Videos")
    List<Videos> getAllVideos();

    @Query("select * from User where group_id=:group_id")
    List<User> searchUsersByGroup(int group_id);

    @Query("select * from DirectMsg where user_id =:user_id and group_id=:group_id")
    List<DirectMsg> searchDirectMsgPair(int user_id, int group_id);

    @Query("select * from DirectMsg where dm_id=:dm_id")
    List<DirectMsg> searchPairID(int dm_id);

    @Query("select * from GroupChat where group_id =:group_id")
    List<GroupChat> searchGroupMsg(int group_id);

    @Query("select * from Videos where group_id =:group_id")
    List<Videos> searchVideos(int group_id);

    @Query("select * from Coach where user_id=:user_id")
    Coach searchCoach(int user_id);

    @Query("select * from Goals where date =:date and group_id=:group_id")
    Goals searchGoal(String date, int group_id);

    @Query("select * from User where user_id =:user_id")
    User searchUser(int user_id);

    @Query("select * from User where username =:username and password =:password")
    User logIn(String username, String password);

    @Query("SELECT * FROM User where username LIKE :search")
    User getUsername(String search);

    @Query("select * from Coach where username =:username AND password=:password")
    Coach loginCoach(String username, String password);

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
    @Insert
    void addGroupChat(GroupChat groupChat);

    @Update
    void updateUser(User user);
    @Delete
    void deleteUser(User user);
    @Delete
    void deleteCoach(Coach coach);
    @Delete
    void deleteGroupChat(GroupChat msg);
    @Delete
    void deleteGoals(Goals goals);
    @Delete
    void deleteLinks(Links links);
    @Delete
    void deleteVideos(Videos video);
}