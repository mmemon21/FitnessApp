package com.example.fitnessproject3fall;

import android.os.Bundle;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.Goals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
public class ViewGoalsActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView myDate;
    Goals goals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_goals);

        calendarView =(CalendarView) findViewById(R.id.calender);
        myDate = (TextView) findViewById(R.id.myDate);
        FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();
        TextView groupText = findViewById(R.id.groupMyDate);
        groupText.setText("Group " + LoginActivity.GROUP_ID);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date =  + (month +1) + "/" + dayOfMonth + "/" + (year-2000);
                goals = dao.searchGoal(date, LoginActivity.GROUP_ID);
                if(goals != null){
                    myDate.setText(goals.getGoals_description());
                }else{
                    myDate.setText("No Goal for " + date);
                }
            }
        });

        Button return_button = findViewById(R.id.return_calender);
        return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
