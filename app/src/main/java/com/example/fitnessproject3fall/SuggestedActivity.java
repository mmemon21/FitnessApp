package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SuggestedActivity extends AppCompatActivity {

    private Button Videobt;
    private Button Goalsbt;
    private Button Nutritionbt;
    private Button Backbt;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested);

        Videobt = findViewById(R.id.videobt);
        Goalsbt = findViewById(R.id.goalsbt);
        Nutritionbt = findViewById(R.id.nutritionbt);
        Backbt = findViewById(R.id.backbt);


        Videobt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuggestedActivity.this, SuggestedVideoActivity.class);
                startActivity(intent);
            }
        });

        Goalsbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuggestedActivity.this, SuggestedGoalsActivity.class);
                startActivity(intent);
            }
        });

        Nutritionbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuggestedActivity.this, SuggestedNutritionActivity.class);
                startActivity(intent);
            }
        });

        Backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuggestedActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });
    }


}

