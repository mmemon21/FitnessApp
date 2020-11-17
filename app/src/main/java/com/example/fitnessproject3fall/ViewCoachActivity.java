package com.example.fitnessproject3fall;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        }
    }
}
