package com.example.fitnessproject3fall;


import android.os.Bundle;

import com.example.fitnessproject3fall.model.DirectMsg;
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

public class ViewDirectMsgActivity2 extends AppCompatActivity {
    List<DirectMsg> directMsgs;
    List<DirectMsg> directMsgs2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_direct_msg2);
        FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();

        boolean condition1 = false;//Condition 1 will check if users are in the Direct MSG DB first

        directMsgs = dao.searchDirectMsgPair(ViewDirectMsgActivity.USER_ID, ViewDirectMsgActivity.GROUP_ID);//Search User First
        if(directMsgs == null){
            condition1 = true;
        }
        directMsgs2 = dao.searchDirectMsgPair(ViewDirectMsgActivity.USER_ID_MSG, ViewDirectMsgActivity.GROUP_ID);//Search Person to DM next
        if(directMsgs2 == null){
           condition1 = true;
           Toast.makeText(ViewDirectMsgActivity2.this, "New User!" + ViewDirectMsgActivity.USER_ID_MSG, Toast.LENGTH_SHORT).show(); // non integer input
        }
        /*if(condition1){//If condition 1 is true, we will add two objects int the DB where these two users will be paired by a foreign key "pairID"
            int size_list = dao.getAllMessages().size();
            int pairID = (size_list/2) +1;
            DirectMsg user = new DirectMsg(size_list +1, ViewDirectMsgActivity.USER_ID, "Here is your First Conversation",ViewDirectMsgActivity.GROUP_ID,pairID);
            DirectMsg user2 = new DirectMsg(size_list +2, ViewDirectMsgActivity.USER_ID_MSG, "Only you will have access to this conversation",ViewDirectMsgActivity.GROUP_ID,pairID);
            dao.addMsg(user);
            dao.addMsg(user2);

            directMsgs = FitnessDB.getFitnessDB(this).dao().searchPairID(pairID);
            Log.d("ViewDirectMsgActivity", "Users's" + directMsgs.size());
            RecyclerView rv = findViewById(R.id.direct_msg_conver_list);
            rv.setLayoutManager(new LinearLayoutManager(this));
            rv.setAdapter(new ViewDirectMsgActivity2.Adapter());
            Toast.makeText(ViewDirectMsgActivity2.this, "Added!", Toast.LENGTH_SHORT).show(); // non integer input
        }*/else{
            int size = dao.getAllMessages().size();
            Toast.makeText(ViewDirectMsgActivity2.this, "NonNull!", Toast.LENGTH_SHORT).show(); // non integer input
        }

    }

    private class Adapter extends RecyclerView.Adapter<ItemHolder> {

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(ViewDirectMsgActivity2.this);
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            holder.bind(directMsgs.get(position));
        }

        @Override
        public int getItemCount() {
            return directMsgs.size();
        }

    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item, parent, false));
        }

        public void bind(DirectMsg f) {
            TextView item = itemView.findViewById(R.id.item_id);
            item.setText(f.toString());
        }
    }
}
