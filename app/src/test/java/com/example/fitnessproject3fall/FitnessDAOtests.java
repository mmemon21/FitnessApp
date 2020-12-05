package com.example.fitnessproject3fall;

import android.app.Application;
import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.io.IOException;
import java.util.List;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.*;
import androidx.test.platform.app.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import android.content.Context;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import org.junit.Test;

public class FitnessDAOTests {

    private FitnessDAO fitnessDAO;
    private FitnessDB db;

    @Before
    public void createDatabase(){
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, FitnessDB.class).build();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

//    @Test
//    public void addUserToDatabase() {
//        FitnessDB testUser = new
//    }
}
