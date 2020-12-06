package com.example.fitnessproject3fall;

import android.content.Context;

import com.example.fitnessproject3fall.model.Coach;
import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.Goals;
import com.example.fitnessproject3fall.model.GroupChat;
import com.example.fitnessproject3fall.model.Links;
import com.example.fitnessproject3fall.model.User;
import com.example.fitnessproject3fall.model.Videos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import static org.junit.Assert.assertEquals;

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
    public void groupChatTest() throws Exception{
        GroupChat chat = new GroupChat(10, 2, "message", 2000, "name", "3:54PM");
        fitnessDAO.addGroupChat(chat);
        assertEquals(chat.getMessage(), "message");
        assertEquals(chat.getCurrentTime(), "3:54PM");
        assertEquals(chat.getName(), "name");
        assertEquals(chat.getGroup_id(), 2000);
        fitnessDAO.deleteGroupChat(chat);
    }

    @Test
    public void addGoalsTest() throws Exception{
        Goals new_goal = new Goals(20,2000, "Run three miles", "12/25/20");
        fitnessDAO.addGoals(new_goal);
        assertEquals(new_goal.getCount(),20);
        assertEquals(new_goal.getGroup_id(),2000);
        assertEquals(new_goal.getGoals_description(),"Run three miles");
        assertEquals(new_goal.getDate(),"12/25/20");
        fitnessDAO.deleteGoals(new_goal);
    }
    @Test
    public void addLinksTest()throws Exception{
        Links new_link = new Links(20,1000,"https://www.lmh.org/news/2017-news/10-small-ways-to-improve-your-nutrition/","10 small ways to improve your nutrition", "Nutrition");
        fitnessDAO.addLinks(new_link);
        assertEquals(new_link.getCount(),20);
        assertEquals(new_link.getGroup_id(),1000);
        assertEquals(new_link.getLink_url(),"https://www.lmh.org/news/2017-news/10-small-ways-to-improve-your-nutrition/");
        assertEquals(new_link.getDescription(),"10 small ways to improve your nutrition");
        fitnessDAO.deleteLinks(new_link);
    }
    @Test
    public void addVideosTest() throws Exception{
        Videos new_video = new Videos(20,2000,"<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/05DpAV5M_Lk\" frameborder=\"0\" allowfullscreen></iframe>");
        fitnessDAO.addVideos(new_video);
        assertEquals(new_video.getCount(),20);
        assertEquals(new_video.getGroup_id(),2000);
        assertEquals(new_video.getVideo_url(),"<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/05DpAV5M_Lk\" frameborder=\"0\" allowfullscreen></iframe>");
        fitnessDAO.deleteVideos(new_video);
    }
}
