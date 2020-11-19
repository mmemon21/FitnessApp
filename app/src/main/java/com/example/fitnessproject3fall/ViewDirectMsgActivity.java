package com.example.fitnessproject3fall;


import android.content.Intent;
import android.os.Bundle;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.Goals;
import com.example.fitnessproject3fall.model.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class ViewDirectMsgActivity extends AppCompatActivity {
    List<User> users;

    public static int USER_ID_MSG;
    public static int USER_ID = 1;
    public static int GROUP_ID = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_direct_msg);
        FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();

        Button select_user = findViewById(R.id.select_dmsg_button);
        select_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText id = findViewById(R.id.direct_msg_id);
                    int user_id = Integer.parseInt(id.getText().toString());
                    User user;
                    user = dao.searchUser(user_id);
                    if (user == null) {
                        Toast.makeText(ViewDirectMsgActivity.this, "User not found!", Toast.LENGTH_SHORT).show(); // non integer input
                    } else {
                        ViewDirectMsgActivity.USER_ID_MSG = user_id;
                        Intent intent = new Intent(ViewDirectMsgActivity.this, ViewDirectMsgActivity2.class);
                        startActivity(intent);
                    }
                }catch (Exception e){
                    Toast.makeText(ViewDirectMsgActivity.this, "Enter correct input!", Toast.LENGTH_SHORT).show(); // non integer input
                }
            }
        });


        users = FitnessDB.getFitnessDB(this).dao().searchUsersByGroup(GROUP_ID);
        Log.d("ViewDirectMsgActivity", "Users's" + users.size());
        RecyclerView rv = findViewById(R.id.directMsg_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ViewDirectMsgActivity.Adapter());

    }

    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(ViewDirectMsgActivity.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            holder.bind(users.get(position));
        }

        @Override
        public int getItemCount() {
            return users.size();
        }

    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(User f) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }

}

