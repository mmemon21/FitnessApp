package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.Goals;
import com.example.fitnessproject3fall.model.User;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class SuggestedGoalsActivity extends AppCompatActivity {

    private EditText mdate;
    private EditText mdescription;
    private Button mAddgoalBt;

    FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_goals);

        mdate = findViewById(R.id.et_date);
        mdescription = findViewById(R.id.et_description);
        mAddgoalBt = findViewById(R.id.bt_add_goal);

        dao = FitnessDB.getFitnessDB(this).dao();

        mAddgoalBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = mdate.getText().toString();
                String description = mdescription.getText().toString();

                List<Goals> goalsList = dao.getAllGoals();
                int goal_size = goalsList.size();
                int goal_count= goal_size +1;
                int group_id = LoginActivity.GROUP_ID;

                Goals new_goal = new Goals(goal_count,group_id,description,date);
                dao.addGoals(new_goal);
                Toast.makeText(SuggestedGoalsActivity.this, "Your suggested goal has been added" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SuggestedGoalsActivity.this, SuggestedActivity.class);
                startActivity(intent);
            }
        });
    }
}
