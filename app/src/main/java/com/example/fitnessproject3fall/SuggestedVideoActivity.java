package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.Videos;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class SuggestedVideoActivity extends AppCompatActivity {
    private EditText mlink;
    private Button mAddvideoBt;

    FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_video);

        mlink = findViewById(R.id.et_link);
        mAddvideoBt = findViewById(R.id.bt_add_video);

        dao = FitnessDB.getFitnessDB(this).dao();

        mAddvideoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = mlink.getText().toString();

                List<Videos> videosList = dao.getAllVideos();
                int video_size = videosList.size();
                int video_count = video_size +1;
                int group_id = LoginActivity.GROUP_ID;
                String video_link = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/"+ link + "\" frameborder=\"0\" allowfullscreen></iframe>";
                Videos new_video = new Videos(video_count,group_id,video_link);
                dao.addVideos(new_video);
                Toast.makeText(SuggestedVideoActivity.this, "Your suggested video has been added" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SuggestedVideoActivity.this, SuggestedActivity.class);
                startActivity(intent);
            }
        });
    }
}
