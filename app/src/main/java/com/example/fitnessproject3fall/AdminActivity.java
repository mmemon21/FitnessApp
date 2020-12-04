package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.User;

import java.util.List;

public class AdminActivity extends AppCompatActivity {

    public static boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();

        List<User> users;
        users = dao.getAllUser();

        User user = dao.searchUser(LoginActivity.USER_ID);

        Button logoutButton = findViewById(R.id.logoutButtonA);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Button profileButton = findViewById(R.id.profileButtonA);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, ViewProfileActivity.class);
                startActivity(intent);
            }
        });

        Button calendarButton = findViewById(R.id.calendarButtonA);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, ViewGoalsActivity.class);
                startActivity(intent);
            }
        });


        Button bmiButton = findViewById(R.id.bmiButtonA);
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, BmiActivity.class);
                startActivity(intent);
            }
        });

        Button chatButton = findViewById(R.id.chatButtonA);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, ViewGroupChatActivity.class);
                startActivity(intent);
            }
        });

        Button view_videos_btn = findViewById(R.id.vidsButtonA);
        view_videos_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, ViewVideosActivity.class);
                startActivity(intent);
            }
        });

        Button suggestedButton = findViewById(R.id.suggestionButton);
        suggestedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, SuggestedActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //super.onOptionsItemSelected(item);
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return onOptionsItemSelected(item);
    }
}