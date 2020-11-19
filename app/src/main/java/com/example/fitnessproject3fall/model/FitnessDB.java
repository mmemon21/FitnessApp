package com.example.fitnessproject3fall.model;

import android.content.Context;
import android.util.Log;

import java.util.List;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, DirectMsg.class,Coach.class, Goals.class,Links.class, Videos.class}, version = 1)
public abstract class FitnessDB extends RoomDatabase{
    private static FitnessDB instance;
    public abstract FitnessDAO dao();
    public abstract UserDAO Userdao();
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
            loadCoach(context);
            loadGoals(context);
            loadLinks(context);
            loadVideos(context);
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
        DirectMsg msg1 = new DirectMsg(1,10, "Hello Daniel How are you!?", 1);
        DirectMsg msg2 = new DirectMsg(2,20, "Good Raul, how about yourself?", 1);
        dao.addMsg(msg1);
        dao.addMsg(msg2);
    }

    private void loadCoach(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        Coach coach1 = new Coach(1, "Glen", "Bruns",40, "", "hello I'm glen bruns", "glen445",
                "glen123", 1);
        Coach coach2 = new Coach(2, "Drew", "Clinkenbeard",35, "", "hello i'm dr C", "drew445",
                "drew123", 2);
        dao.addCoach(coach1);
        dao.addCoach(coach2);
    }

    private void loadGoals(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        Goals goal1 = new Goals(1, 1,"100 Push Ups\n+200 Situps + 20 min run","11/23/20");
        Goals goal2 = new Goals(2, 1,"50 Push Ups\n+100 Situps + 15 min sprints","11/24/20");
        Goals goal3 = new Goals(3, 1,"150 Push Ups\n+100 Situps + 5 min run","11/25/20");
        Goals goal4 = new Goals(4, 1,"70 Push Ups\n+200 Situps + 40 min run","11/26/20");
        Goals goal5 = new Goals(5, 1,"60 Push Ups\n+200 Situps + 30 min run","11/27/20");

        Goals goal6 = new Goals(6, 2,"100 Push Ups\n+200 Situps + 20 min run","11/23/20");
        Goals goal7 = new Goals(7, 2,"50 Push Ups\n+100 Situps + 20 min run","11/24/20");
        Goals goal8 = new Goals(8, 2,"150 Push Ups\n+100 Situps + 5 min run","11/25/20");
        Goals goal9 = new Goals(9, 2,"70 Push Ups\n+200 Situps + 40 min run","11/26/20");
        Goals goal10 = new Goals(10, 2,"60 Push Ups\n+200 Situps + 30 min run","11/27/20");
        dao.addGoals(goal1);
        dao.addGoals(goal2);
        dao.addGoals(goal3);
        dao.addGoals(goal4);
        dao.addGoals(goal5);

        dao.addGoals(goal6);
        dao.addGoals(goal7);
        dao.addGoals(goal8);
        dao.addGoals(goal9);
        dao.addGoals(goal10);
    }
    private void loadLinks(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        Links link1 = new Links(1, 1, "https://www.healthline.com/nutrition/50-super-healthy-foods");
        Links link2 = new Links(2, 1, "https://www.eatthis.com/healthiest-foods-on-planet/");
        Links link3 = new Links(3, 2, "https://www.healthline.com/nutrition/50-super-healthy-foods");
        Links link4 = new Links(4, 2, "https://www.eatthis.com/healthiest-foods-on-planet/");

        dao.addLinks(link1);
        dao.addLinks(link2);
        dao.addLinks(link3);
        dao.addLinks(link4);
    }
    private void loadVideos(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        Videos video1 = new Videos(1, 1, "https://www.youtube.com/watch?v=28CIFOhkKrU");
        Videos video2 = new Videos(2, 1, "https://www.youtube.com/watch?v=05DpAV5M_Lk");
        Videos video3 = new Videos(3, 2, "https://www.youtube.com/watch?v=28CIFOhkKrU");
        Videos video4 = new Videos(4, 2, "https://www.youtube.com/watch?v=05DpAV5M_Lk");

        dao.addVideos(video1);
        dao.addVideos(video2);
        dao.addVideos(video3);
        dao.addVideos(video4);
    }


}
