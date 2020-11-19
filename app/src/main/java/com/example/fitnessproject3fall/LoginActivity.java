package com.example.fitnessproject3fall;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.User;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity  extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button Loginbt;
    private Button Registerbt;
    private FitnessDB db;

    public static int USER_ID;
    public static int GROUP_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FitnessDB.getFitnessDB(LoginActivity.this).loadData(this);

        FitnessDAO dao = FitnessDB.getFitnessDB(this).dao();
        username = findViewById(R.id.et_UserNameLogin);
        password = findViewById(R.id.et_PasswordLogin);
        Loginbt = findViewById(R.id.bt_Login);
        Registerbt = findViewById(R.id.bt_Login_Register);

        Loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name = username.getText().toString();
                String pass_word = password.getText().toString();

                User user = dao.logIn(user_name,pass_word);

                if(user !=null){
                    int user_id = user.getUser_id();
                    int group_id = user.getGroup_id();
                    LoginActivity.USER_ID = user_id;
                    LoginActivity.GROUP_ID = group_id;
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                }
                else{
                    TextView message = findViewById(R.id.errorMessage);

                    message.setText("Sorry username doesn't exist.");
                }

            }

        });
        Registerbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}

/*
        db = FitnessDB.getFitnessDB(getApplicationContext());
        login();
    }

    public void login(){
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
                password.setError("Sorry your password didn't match");
            }
        }


    }

    public Boolean checkUsername(String username){
        User dbUser = db.Userdao().getUsername(username);
        return dbUser == null;
    }

    public Boolean correctPassword(String username ,String password){
        User dbUser = db.Userdao().getUsername(username);
        return dbUser.getPassword().equals(password);
    }
}
*/
