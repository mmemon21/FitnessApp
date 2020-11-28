package com.example.fitnessproject3fall;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject3fall.model.Coach;
import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.Videos;

import java.util.List;

public class ViewVideosActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Videos> videosList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_videos_activity);

        TextView msg = findViewById(R.id.textview_videos);
        FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();

        videosList = dao.searchVideos(LoginActivity.GROUP_ID);
        Coach coach = dao.searchCoach(LoginActivity.GROUP_ID);
        msg.setText("Here are some videos that coach " + coach.getFirst_name() + " provided. ");
        recyclerView = (RecyclerView) findViewById(R.id.view_videos_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        VideosAdapter videosAdapter = new VideosAdapter(videosList);
        recyclerView.setAdapter(videosAdapter);
    }
}
