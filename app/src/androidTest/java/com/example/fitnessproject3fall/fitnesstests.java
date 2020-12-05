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

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.User;

import org.junit.Test;

public class fitnesstests {
    Context context = ApplicationProvider.getApplicationContext();
    private FitnessDB db;
    private FitnessDAO fitnessDAO = FitnessDB.getFitnessDB(context).dao();
    User new_user = new User(3, "first_name", "last_name", 20, "", "", "user_name", "pass_word", 0);

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
    public void addUserToDatabase() throws Exception {
        fitnessDAO.addUser(new_user);
        assertEquals(new_user.getFirst_name(), "first_name");
    }
}
