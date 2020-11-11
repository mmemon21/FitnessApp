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

import java.util.ArrayList;
import java.util.List;

import com.example.fitnessproject3fall.model.Coach;
import com.example.fitnessproject3fall.model.User;
import com.example.fitnessproject3fall.model.UserDAO;

public class GenericRecyclerView extends AppCompatActivity {
    static List<User> assignments;
    List<User> enrollments;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        Log.d("LoginActivity", "onCreate called");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.generic_recycler_view);
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

        /** A list to get all assignments, then if the assignment is not null a Recycler view is implemented to show assignments */
        if(assignments == null) {
            assignments = UserDAO.getAllUsers();
        }

        if(assignments != null)
            Log.d("ViewAssignmentsActivity", "Assignments's" + assignments.size());

        RecyclerView rv2 = findViewById(R.id.recycler_view_assignments);
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv2.setAdapter(new Adapter());
    }

    /**
     * The Adapter for the RecyclerView for ItemHolders, the constructor helps create the view
     * and the bind view binds the items to the holder
     */
    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public GenericRecyclerView.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(GenericRecyclerView.this);
            return new GenericRecyclerView.ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(GenericRecyclerView.ItemHolder holder, int position){
            holder.bind(assignments.get(position));


        }

        @Override
        public int getItemCount() {
            if(assignments == null){
                return 0;
            }
            return assignments.size();
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(User f ) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }
}
