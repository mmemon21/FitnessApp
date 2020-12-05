package com.example.fitnessproject3fall.model;

import android.content.Context;
import android.util.Log;
import android.widget.CalendarView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, DirectMsg.class,Coach.class, Goals.class,Links.class, Videos.class, GroupChat.class}, version = 1)
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
            loadCoach(context);
            loadGoals(context);
            loadLinks(context);
            loadVideos(context);
            loadGroupChat(context);
        }
    }
    private void loadUsers(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        User user1 = new User(1, "Raul", "Perez", 21,
                "https://firebasestorage.googleapis.com/v0/b/fitnessproject3fallk.appspot.com/o/4D8CA5D1-B737-41E5-A6C4-B5B878420D37_1_201_a.jpeg?alt=media&token=e862d969-6eed-4797-a43b-ef7350b24d7f",
                "Hello my name Is raul ** edit later","raul676", "RaulP676",1000);
        User user2 = new User(2, "Mike", "Zuniga", 54,
                "https://firebasestorage.googleapis.com/v0/b/fitnessproject3fallk.appspot.com/o/IMG_8306.PNG?alt=media&token=ffe838d1-13ad-4392-8ecb-b60b63699808",
                "hello I'm Mike Zuniga... edit later","mike123", "mike123", 1000);
        User user3 = new User(3, "Daniel", "Kufer", 22,
                "https://firebasestorage.googleapis.com/v0/b/fitnessproject3fallk.appspot.com/o/profilepic.jpg?alt=media&token=e515ebf0-1061-4b05-9e90-77f5f5fb3eca",
                "Hello I'm daniel.. edit later","daniel123", "daniel123", 1000);
        User user4 = new User(4, "Kevin", "Piffero", 24,
                "https://firebasestorage.googleapis.com/v0/b/fitnessproject3fallk.appspot.com/o/img_0249.jpg?alt=media&token=6fbe74d7-8645-4e1e-996f-0b2271e382ae",
                "Hello I'm Kevin... edit later","kevin456", "kevin456", 2000);
        User user5 = new User(5, "Mustafa", "Memon", 23,
                "https://firebasestorage.googleapis.com/v0/b/fitnessproject3fallk.appspot.com/o/picture.png?alt=media&token=49a9b445-edc6-48b3-a0e1-618787215029",
                "Hello I'm Mustafa... edit later","mustafa789", "mustafa789", 2000);
        User user6 = new User(1000, "Glen", "Bruns",40,
                "https://firebasestorage.googleapis.com/v0/b/fitnessproject3fallk.appspot.com/o/grb-headshot.jpg?alt=media&token=77d9170f-0ee8-47ce-8452-cc0681448b06",
                "hello I'm glen bruns", "glen445","glen123", 1000);
        User user7 = new User(2000, "Drew", "Clinkenbeard",35,
                "https://firebasestorage.googleapis.com/v0/b/fitnessproject3fallk.appspot.com/o/profile.JPG?alt=media&token=fcf817c2-be67-4008-acc2-9ebf94a9bd24",
                "hello i'm dr C", "drew445","drew123", 2000);

        dao.addUser(user1);
        dao.addUser(user2);
        dao.addUser(user3);
        dao.addUser(user4);
        dao.addUser(user5);
        dao.addUser(user6);
        dao.addUser(user7);
    }

    private void loadDirectMsg(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        DirectMsg msg1 = new DirectMsg(1,1, "Hello Daniel How are you!?", 1000,1);
        DirectMsg msg2 = new DirectMsg(2,3, "Good Raul, how about yourself?", 1000,1);
        dao.addMsg(msg1);
        dao.addMsg(msg2);
    }

    private void loadGroupChat(Context context){
        Date current_date = Calendar.getInstance().getTime();
        FitnessDAO dao = getFitnessDB(context).dao();
        GroupChat msg1 = new GroupChat(1,1000,"Good Morning I'm Glen Bruns! I'm you're coach", 1000, "Glen B.",""+current_date);
        GroupChat msg2 = new GroupChat(2,2000,"Good Morning I'm Drew Clinkenbeard! I'm you're coach", 2000, "Drew C.",""+current_date);
        dao.addGroupChat(msg1);
        dao.addGroupChat(msg2);
    }

    private void loadCoach(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        Coach coach1 = new Coach(1000, "Glen", "Bruns",40, "", "hello I'm glen bruns", "glen445",
                "glen123", 1000);
        Coach coach2 = new Coach(2000, "Drew", "Clinkenbeard",35, "", "hello i'm dr C", "drew445",
                "drew123", 2000);
        dao.addCoach(coach1);
        dao.addCoach(coach2);
    }

    private void loadGoals(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        Goals goal1 = new Goals(1, 1000,"100 Push Ups\n+200 Situps + 20 min run","12/23/20");
        Goals goal2 = new Goals(2, 1000,"50 Push Ups\n+100 Situps + 15 min sprints","12/24/20");
        Goals goal3 = new Goals(3, 1000,"150 Push Ups\n+100 Situps + 5 min run","12/25/20");
        Goals goal4 = new Goals(4, 1000,"70 Push Ups\n+200 Situps + 40 min run","12/26/20");
        Goals goal5 = new Goals(5, 1000,"60 Push Ups\n+200 Situps + 30 min run","12/27/20");

        Goals goal6 = new Goals(6, 2000,"100 Push Ups\n+200 Situps + 20 min run","12/23/20");
        Goals goal7 = new Goals(7, 2000,"50 Push Ups\n+100 Situps + 20 min run","12/24/20");
        Goals goal8 = new Goals(8, 2000,"150 Push Ups\n+100 Situps + 5 min run","12/25/20");
        Goals goal9 = new Goals(9, 2000,"70 Push Ups\n+200 Situps + 40 min run","12/26/20");
        Goals goal10 = new Goals(10, 2000,"60 Push Ups\n+200 Situps + 30 min run","12/27/20");
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
        Links link1 = new Links(1, 1000, "https://www.healthline.com/nutrition/50-super-healthy-foods","50 Super Healthy Foods", "Nutrition");
        Links link2 = new Links(2, 1000, "https://www.eatthis.com/healthiest-foods-on-planet/","Eat This Not That!", "Nutrition");
        Links link3 = new Links(3, 1000, "https://www.helpguide.org/articles/healthy-living/the-mental-health-benefits-of-exercise.htm","Mental Health Benefits from Exercise!", "Exercise");
        Links link4 = new Links(4, 1000, "https://simpleprogrammer.com/programmers-exercise/","Programming + Exercise!", "Random");

        Links link5 = new Links(5, 2000, "https://www.healthline.com/nutrition/50-super-healthy-foods","50 Super Healthy Foods", "Nutrition");
        Links link6 = new Links(6, 2000, "https://www.eatthis.com/healthiest-foods-on-planet/","Eat This Not That!", "Nutrition");
        Links link7 = new Links(7, 2000, "https://www.helpguide.org/articles/healthy-living/the-mental-health-benefits-of-exercise.htm","Mental Health Benefits from Exercise!", "Exercise");
        Links link8 = new Links(8, 2000, "https://simpleprogrammer.com/programmers-exercise/","Programming + Exercise!", "Random");

        dao.addLinks(link1);
        dao.addLinks(link2);
        dao.addLinks(link3);
        dao.addLinks(link4);

        dao.addLinks(link5);
        dao.addLinks(link6);
        dao.addLinks(link7);
        dao.addLinks(link8);
    }
    private void loadVideos(Context context){
        FitnessDAO dao = getFitnessDB(context).dao();
        Videos video1 = new Videos(1, 1000, "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/28CIFOhkKrU\" frameborder=\"0\" allowfullscreen></iframe>");
        Videos video2 = new Videos(2, 1000, "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/05DpAV5M_Lk\" frameborder=\"0\" allowfullscreen></iframe>");
        Videos video3 = new Videos(3, 2000, "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/28CIFOhkKrU\" frameborder=\"0\" allowfullscreen></iframe>");
        Videos video4 = new Videos(4, 2000, "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/05DpAV5M_Lk\" frameborder=\"0\" allowfullscreen></iframe>");

        dao.addVideos(video1);
        dao.addVideos(video2);
        dao.addVideos(video3);
        dao.addVideos(video4);
    }



}
