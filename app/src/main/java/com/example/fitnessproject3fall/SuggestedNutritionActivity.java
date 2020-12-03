package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.Links;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class SuggestedNutritionActivity extends AppCompatActivity {

    private EditText mlink;
    private Button mAddnutritionBt;

    FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_nutrition);

        mlink = findViewById(R.id.et_link);
        mAddnutritionBt = findViewById(R.id.bt_add_nutrition);

        dao = FitnessDB.getFitnessDB(this).dao();

        mAddnutritionBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = mlink.getText().toString();

                List<Links> nutritionList = dao.getAllNutrition();
                int nutrition_size = nutritionList.size();
                int nutrition_count = nutrition_size +1;
                int group_id = LoginActivity.GROUP_ID;

                Links new_nutrition = new Links(nutrition_count,group_id, link);
                dao.addLinks(new_nutrition);
                Toast.makeText(SuggestedNutritionActivity.this, "Your nutrition suggestion has been added" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SuggestedNutritionActivity.this, SuggestedActivity.class);
                startActivity(intent);
            }
        });
    }

}
