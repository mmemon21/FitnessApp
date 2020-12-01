package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessproject3fall.model.Coach;
import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.User;

import java.util.ArrayList;
import java.util.List;

public class ViewAdminProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_admin_profile);
        FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();
        User user = dao.searchUser(LoginActivity.USER_ID);
        Coach coach = dao.searchCoach(LoginActivity.GROUP_ID);
        List<Coach> list_coach = dao.getAllCoach();

        ArrayList<Integer> list_id = new ArrayList<>();
        for(int i =0; i < list_coach.size(); i++){
            list_id.add(list_coach.get(i).getUser_id());
        }
        boolean status = false;
        for(int j =0; j < list_id.size(); j++){
            if(user.getUser_id() == list_id.get(j)){
                status = true;
            }
        }
        TextView status_text = findViewById(R.id.memberstatusA);
        if(status){
            status_text.setText("Coach");
        }else{
            status_text.setText("Group Member");
        }
        TextView full_name = findViewById(R.id.fullNameA);
        full_name.setText(user.getFirst_name() + " " + user.getLast_name());

        TextView age = findViewById(R.id.ageTextViewA);
        age.setText(""+user.getAge());

        TextView coach_name = findViewById(R.id.coachTextViewA);
        coach_name.setText(coach.getFirst_name() + " " + coach.getLast_name());

        TextView user_name = findViewById(R.id.usernameTextViewA);
        user_name.setText(user.getUsername());

        TextView bio = findViewById(R.id.viewBioA);
        bio.setText(user.getBio());

        Button menuButton = findViewById(R.id.menuButtonA);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button edit_profile = findViewById(R.id.editProfileButtonA);
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAdminProfileActivity.this, EditAdminProfileActivity.class);
                startActivity(intent);
            }
        });


    }
}





