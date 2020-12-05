package com.example.fitnessproject3fall;

import android.app.Application;
import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.util.List;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import android.content.Context;

import com.example.fitnessproject3fall.model.Coach;
import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.User;

import org.junit.Test;

public class fitnesstests {
    Context context = ApplicationProvider.getApplicationContext();
    private FitnessDB db;
    private FitnessDAO fitnessDAO = FitnessDB.getFitnessDB(context).dao();

    @Before
    public void createDatabase(){
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, FitnessDB.class).build();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void addUserToDatabaseTest() throws Exception {
        User new_user = new User(500, "testuser", "last_name", 20, "", "", "user_name", "pass_word", 100);
        fitnessDAO.addUser(new_user);
        assertEquals(new_user.getFirst_name(), "testuser");
        assertEquals(new_user.getAge(), 20);
        assertEquals(new_user.getBio(), "");
       // new_user = new User(300, "testuser", "last_name", 20, "", "", "user_name", "pass_word", 100);
        fitnessDAO.deleteUser(new_user);
    }

    @Test
    public void addCoachToDatabaseTest() throws Exception{
        Coach new_coach = new Coach(6000, "Glenn", "Bruns", 40, "", "", "glenn22", "password", 2000);
        fitnessDAO.addCoach(new_coach);
        assertEquals(new_coach.getFirst_name(), "Glenn");
        assertEquals(new_coach.getAge(), 40);
        assertEquals(new_coach.getBio(), "");
        fitnessDAO.deleteCoach(new_coach);
    }

    @Test //tbd
    public void testMessages() throws Exception{

    }
}
