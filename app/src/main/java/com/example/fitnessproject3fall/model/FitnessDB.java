package com.example.fitnessproject3fall.model;

import android.content.Context;
import android.util.Log;

import java.util.List;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, DirectMsg.class}, version = 1)
public abstract class FitnessDB extends RoomDatabase{
    private static FitnessDB instance;
    public abstract FitnessDAO dao();
    public static FitnessDB getFitnessDB(final Context context){
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FitnessDB.class,
                    "FitnessDB").allowMainThreadQueries().build();
        }
        return instance;
    }
    public void loadData(Context context){
        List<User> user_list = FitnessDB.getFitnessDB(context).dao().getAllUser();
        if(user_list.size() ==0) {
            Log.d("FitnessDB", "loading data");
            loadUsers(context);
            loadDirectMsg(context);
        }
    }
    private void loadUsers(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        User user1 = new User(1, "Raul", "Perez", 21,"", "Hello my name Is raul ** edit later",
                "raul676", "RaulP676",1);
        User user2 = new User(2, "Joe", "Ramirez", 22, "","hello I'm Joe... edit later",
                "joem445", "joeMon455", 1);
        User user3 = new User(3, "Daniel", "Kufer", 22, "", "Hello I'm daniel.. edit later",
                "daniel123", "daniel123", 1);
        User user4 = new User(4, "Kevin", "Piffero", 24, "", "Hello I'm Kevin... edit later",
                "kevin456", "kevin456", 2);
        User user5 = new User(5, "Mustafa", "Memon", 23, "", "Hello I'm Mustafa... edit later",
                "mustafa789", "mustafa789", 2);

        dao.addUser(user1);
        dao.addUser(user2);
        dao.addUser(user3);
        dao.addUser(user4);
        dao.addUser(user5);
    }

    private void loadDirectMsg(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        DirectMsg msg1 = new DirectMsg(1,10, "Hello Emory How are you!?", 1);
        DirectMsg msg2 = new DirectMsg(2,20, "Good Raul, how about yourself?", 1);
        dao.addMsg(msg1);
        dao.addMsg(msg2);
    }


}
