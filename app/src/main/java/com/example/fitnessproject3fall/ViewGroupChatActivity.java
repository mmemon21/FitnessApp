package com.example.fitnessproject3fall;


import android.os.Bundle;

import com.example.fitnessproject3fall.model.DirectMsg;
import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.Goals;
import com.example.fitnessproject3fall.model.GroupChat;
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

import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class ViewGroupChatActivity extends AppCompatActivity {
    List<GroupChat> group_chat;

    Date currentTime = Calendar.getInstance().getTime();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_groupchat);
        FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();
        User user = dao.searchUser(LoginActivity.USER_ID);

        String fName = user.getFirst_name();
        String lName = user.getLast_name();

        String name = fName + " " + lName +".";
        Button send_msg = findViewById(R.id.send_msg_group_button);

        TextView msg = findViewById(R.id.group_name);
        msg.setText("Group " + LoginActivity.GROUP_ID);
        send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText msg = findViewById(R.id.send_msg_group);
                String message = msg.getText().toString();
                int size_chat = dao.getAllGroupMsg().size();
                size_chat++;

                GroupChat chat = new GroupChat(size_chat, 2, message, LoginActivity.GROUP_ID , name, ""+currentTime);
                dao.addGroupChat(chat);
                Toast.makeText(ViewGroupChatActivity.this, "Message Sent!", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            }
        });

        Button back_button =  findViewById(R.id.back_groupMsg);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        group_chat = dao.searchGroupMsg(LoginActivity.GROUP_ID);
        Log.d("ViewGroupChat", "GroupMessage's" + group_chat.size());
        RecyclerView rv = findViewById(R.id.group_chat_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter());

    }

    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(ViewGroupChatActivity.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            holder.bind(group_chat.get(position));
        }

        @Override
        public int getItemCount() {
            return group_chat.size();
        }

    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(GroupChat f) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }
}
