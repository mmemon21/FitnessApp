package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.User;

import org.w3c.dom.Text;

public class EditProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();
        User user = dao.searchUser(LoginActivity.USER_ID);

        EditText preview_bio = findViewById(R.id.edit_bio);
        preview_bio.setText(user.getBio());

        EditText first_name = findViewById(R.id.edit_firstname);
        first_name.setText(user.getFirst_name());

        EditText last_name = findViewById(R.id.edit_lastname);
        last_name.setText(user.getLast_name());

        EditText url = findViewById(R.id.edit_photo);
        url.setText(user.getProfile_url());

        Button update_user = findViewById(R.id.edit_profile_button);
        update_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = first_name.getText().toString();
                String lname = last_name.getText().toString();
                String bio = preview_bio.getText().toString();
                String profilepic = url.getText().toString();

                user.setFirst_name(fname);
                user.setLast_name(lname);
                user.setBio(bio);
                user.setProfile_url(profilepic);
                dao.updateUser(user);
                Toast.makeText(EditProfileActivity.this, "You're profile has been updated " + user.getFirst_name() + "!" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditProfileActivity.this, ViewProfileActivity.class);
                startActivity(intent);
            }
        });


        Button backbtn = findViewById(R.id.back_editprofile);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}

