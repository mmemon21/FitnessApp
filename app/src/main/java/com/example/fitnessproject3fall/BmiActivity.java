package com.example.fitnessproject3fall;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BmiActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        Button back_button = findViewById(R.id.back_bmi_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void calculate(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr);
            float weightValue = Float.parseFloat(weightStr);

            displayBMI(calculateBMI(heightValue,weightValue));
        }
    }

    public static float calculateBMI(float heightValue, float weightValue){
        return weightValue / (heightValue * heightValue);
    }
    //bmi= (mass/height^2)

    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = "Very Severely\n Underweight";
            result.setTextColor(Color.rgb(0, 44, 165));
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = "Severely \nUnderweight";
            result.setTextColor(Color.rgb(50, 141, 226));
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "Underweight";
            result.setTextColor(Color.rgb(170, 214, 225));
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = "Normal";
            result.setTextColor(Color.rgb(42, 235, 99));
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "Overweight";
            result.setTextColor(Color.rgb(248, 245, 51));
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = "Moderately \nObese\n Class I";
            result.setTextColor(Color.rgb(248, 186, 51));
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = "Severely Obese \n  \nClass II";
            result.setTextColor(Color.rgb(248, 91, 51));
        } else {
            bmiLabel = "Very Severely \nObese \n Class III";
            result.setTextColor(Color.rgb(255, 0, 0));
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }

}