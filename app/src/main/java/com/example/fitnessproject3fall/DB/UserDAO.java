package com.example.fitnessproject3fall.DB;

import com.example.fitnessproject3fall.model.User;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import java.util.List;
@Dao
public interface UserDAO {

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Query("SELECT * FROM users where username LIKE :search")
    User getUserWithUsername(String search);

    @Query("Select * From users where user_id = :userId")
    User getUserId (Integer userId);
}
