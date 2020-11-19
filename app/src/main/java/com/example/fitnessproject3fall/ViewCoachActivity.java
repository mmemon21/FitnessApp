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
import com.example.fitnessproject3fall.model.User;

public class ViewCoachActivity extends AppCompatActivity {
    List<Coach> coaches;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_view_coach);

        FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();
        /** If the user clicks the return button they are lead back to the main menu */
        Button return_main_button = findViewById(R.id.back);
        return_main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("GenericRecyclerView", "onClick return called");
                finish();
            }
        });

        coaches = dao.getAllCoach();
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
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(ViewCoachActivity.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position){
            holder.bind(coaches.get(position));
        }

        @Override
        public int getItemCount() {

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
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //use position value  to get clicked data from list
                    try {
                        FitnessDAO dao = FitnessDB.getFitnessDB(ViewCoachActivity.this).dao();
                        int user_id = RegisterActivity.tempUserID;
                        User newUser = dao.searchUser(user_id);
                        newUser.setGroup_id(f.getGroup_id());

                        AlertDialog.Builder builder = new AlertDialog.Builder(ViewCoachActivity.this);
                        builder.setTitle("Coach selected successfully!");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //finish();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                        Intent intent = new Intent(ViewCoachActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }catch (Exception e)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ViewCoachActivity.this);
                        builder.setTitle("Something went wrong");
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
            });
        }
    }
}
