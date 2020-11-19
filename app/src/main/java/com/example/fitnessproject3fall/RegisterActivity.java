package com.example.fitnessproject3fall;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.User;

import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText firstName;
    private  EditText lastName;
    private EditText age;
    private Button Registerbt;
    public static int tempUserID;

    FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();

    @Override
    protected  void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.et_UserName);
        password = findViewById(R.id.et_Password);
        firstName = findViewById(R.id.et_FirstName);
        lastName = findViewById(R.id.et_LastName);
        age = findViewById(R.id.et_Age);
        Registerbt= findViewById(R.id.bt_Register);

        dao = FitnessDB.getFitnessDB(this).dao();

        Registerbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_name = username.getText().toString();
                String pass_word = password.getText().toString();
                String first_name = firstName.getText().toString();
                String last_name = lastName.getText().toString();
                int Age = Integer.parseInt(age.getText().toString());
                List<User> userList = dao.getAllUser();
                int user_size = userList.size();
                int user_id = user_size+ 1;

                boolean user_true = checkUsernameValid(user_name);
                boolean password_true = checkValidPassword(pass_word);

                if (user_true && password_true) {
                    User user = dao.getUsername(user_name);
                    if (user == null) {
                        User new_user = new User(user_id, first_name, last_name, Age, "", "", user_name, pass_word, 0);
                        dao.addUser(new_user);
                        Toast.makeText(RegisterActivity.this,  ""+ first_name + " " + last_name + " Welcome, Please Sign in", Toast.LENGTH_SHORT).show();
                        tempUserID = user_id;
                        Intent intent = new Intent(RegisterActivity.this,ViewCoachActivity.class);
                        startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        builder.setTitle("Username is already taken.");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("Username or password format is invalid.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            /**Closes alert Dialog after okay clicked*/
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }


    public boolean checkUsernameValid(String username){

        int letters =0;
        int numbers =0;

        if(username.length() < 6){
            return false;
        }
        for(int i =0; i<username.length();i++){
            if(Character.isLetter(username.charAt(i))){
                letters ++;
            }
            if(Character.isDigit(username.charAt(i))){
                numbers++;
            }
        }
        return (letters>=2 && numbers>=2) ? true : false;
    }

    public boolean checkValidPassword(String password){
        if(password.length() >5){
            return true;
        }else{
            return false;
        }
    }
}
