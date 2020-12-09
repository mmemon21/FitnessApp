package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static boolean admin;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("raul");
    private ImageView profilePic;
    FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        profilePic = findViewById(R.id.profileUser);

        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Button profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewProfileActivity.class);
                startActivity(intent);
            }
        });

        Button calendarButton = findViewById(R.id.calendarButton);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewGoalsActivity.class);
                startActivity(intent);
            }
        });


        Button bmiButton = findViewById(R.id.bmiButton);
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BmiActivity.class);
                startActivity(intent);
            }
        });

        Button chatButton = findViewById(R.id.chatButton);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewGroupChatActivity.class);
                startActivity(intent);
            }
        });

        Button view_videos_btn = findViewById(R.id.vidsButton);
        view_videos_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewVideosActivity.class);
                startActivity(intent);
            }
        });

        Button nutritionButton = findViewById(R.id.nutritionButton);
        nutritionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NutritionActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        User user = dao.searchUser(LoginActivity.USER_ID);
        super.onStart();
        first.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(profilePic);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                try {
                    if(!user.getProfile_url().isEmpty()) {
                        Picasso.get().load(user.getProfile_url()).into(profilePic);
                    }else{
                       // Snackbar.make(findViewById(android.R.id.content),"Image empty.\nEdit profile and to add a url.", Snackbar.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Snackbar.make(findViewById(android.R.id.content),"Image URL Error.", Snackbar.LENGTH_LONG).show();
                }
            }

        });
    }

}