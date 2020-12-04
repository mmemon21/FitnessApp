package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.List;

public class AdminActivity extends AppCompatActivity {

    public static boolean admin;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("raul");
    private ImageView profilePic;
    FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        profilePic = findViewById(R.id.adminProfileImg);


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

        Button nutritionBtn = findViewById(R.id.nutritionButtonA);
        nutritionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, NutritionActivity.class);
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
                        Snackbar.make(findViewById(android.R.id.content),"Image empty.\nEdit profile and to add a url.", Snackbar.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Snackbar.make(findViewById(android.R.id.content),"Image URL Error.", Snackbar.LENGTH_LONG).show();
                }
            }

        });
    }

}