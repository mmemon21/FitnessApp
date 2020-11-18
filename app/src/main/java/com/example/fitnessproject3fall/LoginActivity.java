package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.User;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity  extends AppCompatActivity {

    private EditText username;
    private EditText password;

    private FitnessDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.et_UserNameLogin);
        password = findViewById(R.id.et_PasswordLogin);

        db = FitnessDB.getFitnessDB(getApplicationContext());

    }

    public void login(View view){
        checkInput();
    }

    public void checkInput(){
        String user_name = username.getText().toString();
        String pass_word = password.getText().toString();

        Boolean usernameCorrect = checkUsername(user_name);
        Boolean passwordCorrect = correctPassword(user_name, pass_word);

        if(!usernameCorrect && !passwordCorrect && !user_name.isEmpty() && !pass_word.isEmpty()){
            Intent userLogin = new Intent(getApplicationContext(), MainActivity.class);
            userLogin.putExtra("username",user_name);
            startActivity(userLogin);
        }
        else{
            if(usernameCorrect){
                username.setError("Sorry it looks like that username doesn't have an account.");
            }
            if(passwordCorrect){
                password.setError("Sorry your password your password didn't match");
            }
        }


    }

    public Boolean checkUsername(String username){
        User dbUser = db.UserDAO.getUsername(username);
        return dbUser == null;
    }

    public Boolean correctPassword(String username ,String password){
        User dbUser = db.UserDAO.getUsername(username);
        return dbUser.getPassword().equals(password);
    }
}
