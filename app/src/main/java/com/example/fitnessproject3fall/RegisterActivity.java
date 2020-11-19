package com.example.fitnessproject3fall;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fitnessproject3fall.model.FitnessDAO;
import com.example.fitnessproject3fall.model.FitnessDB;
import com.example.fitnessproject3fall.model.User;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText firstName;
    private  EditText lastName;
    private EditText age;
    private Button Registerbt;

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
            public void onClick(View view) {
                register();
            }
        });
    }

    public void register(){
        checkInput();
    }

    public void checkInput(){

        String user_name = username.getText().toString();
        String pass_word =  password.getText().toString();
        String first_name = firstName.getText().toString();
        String last_name = lastName.getText().toString();
        int Age = Integer.parseInt(age.getText().toString());
        List<User> userList = dao.getAllUser();
        int user_size = userList.size();
        int user_id = user_size ++;

        Boolean usernameCorrect = differentUsername(user_name);
        Boolean passwordCorrect = correctPasswordSpecs(pass_word);

        if(usernameCorrect && passwordCorrect && !first_name.isEmpty()&& !last_name.isEmpty() && !user_name.isEmpty() && !pass_word.isEmpty()){

            dao.addUser(new User(user_id,first_name,last_name,Age," ", " ",user_name,pass_word,0));

        }

        if(user_name.isEmpty()){
            username.setError("Whoops it looks like you forgot to enter a username.");
        }
        if(pass_word.isEmpty()){
            password.setError("Whoops it looks like you forgot to enter a password.");
        }
        if(first_name.isEmpty()){
            firstName.setError("Whoops it looks like you forgot to enter your first name.");
        }
        if(last_name.isEmpty()){
            lastName.setError("Whoops it looks like you forgot to enter your last name.");
        }


        else{
            if(!usernameCorrect){
                username.setError("Sorry it looks like that username has been already claimed.");
            }
            if(!passwordCorrect){
                password.setError("Sorry your password was invalid. It must be at least six characters long and containing at least two numbers and two characters.");
            }
        }
    }

    private Boolean differentUsername(String user_name){
        User dbUser = dao.getUsername(user_name);
        return dbUser == null? true : false;
    }

    private Boolean correctPasswordSpecs(String pass_word){
        int letters =0;
        int numbers =0;

        if(pass_word.length() < 6){
            return false;
        }

        for(int i =0; i<pass_word.length();i++){
            if(Character.isLetter(pass_word.charAt(i))){
                letters ++;
            }
            if(Character.isDigit(pass_word.charAt(i))){
                numbers++;
            }
        }
        return (letters>=2 && numbers>=2) ? true : false;
    }
}
