package com.example.fitnessproject3fall;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.fitnessproject3fall.model.Coach;
import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;

public class ViewCoachActivity extends AppCompatActivity {
    static List<Coach> coaches;
    List<Coach> enrollments;
    FitnessDAO aDB = FitnessDB.getFitnessDB(this).dao();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_view_coach);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** If the user clicks the return button they are lead back to the main menu */
        Button return_main_button = findViewById(R.id.back);
        return_main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("GenericRecyclerView", "onClick return called");
                finish();
            }
        });

        /** A list to get all coaches, then if the assignment is not null a Recycler view is implemented to show coaches */
        if(coaches == null) {
            coaches = aDB.getAllCoach();
        }

        if(coaches != null)
            Log.d("ViewcoachesActivity", "coaches's" + coaches.size());

        RecyclerView rv2 = findViewById(R.id.recycler_view_coaches);
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv2.setAdapter(new Adapter());
    }

    /**
     * The Adapter for the RecyclerView for ItemHolders, the constructor helps create the view
     * and the bind view binds the items to the holder
     */
    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ViewCoachActivity.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(ViewCoachActivity.this);
            return new ViewCoachActivity.ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ViewCoachActivity.ItemHolder holder, int position){
            holder.bind(coaches.get(position));
        }

        @Override
        public int getItemCount() {
            if(coaches == null){
                return 0;
            }
            return coaches.size();
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(Coach f ) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());

            //make the item clickable
            /*item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use position value  to get clicked data from list
                    try {
                        int course_id = f.getCourse_id();

                        //GradeDao daoo = GradeRoom.getGradeRoom(ViewAssignmentsActivity.this).dao();
                        //Grade grades = daoo.searchGrade(course_id,MainActivity.userid);
                        ArrayList<Assignment> assignmentsFilter = new ArrayList<Assignment>();
                        for(Assignment i : assignments) {
                            if(i.getCourse_id() == course_id){
                                assignmentsFilter.add(i);
                            }
                        }

                        ViewAssignmentsInOneCourseActivity.assignments = assignmentsFilter;
                        Intent intent = new Intent(ViewAssignmentsActivity.this, ViewAssignmentsInOneCourseActivity.class);
                        startActivity(intent);
                    }catch (Exception e)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ViewAssignmentsActivity.this);
                        builder.setTitle("Please enter a valid course ID.");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //finish();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
            });*/
        }
    }
}
