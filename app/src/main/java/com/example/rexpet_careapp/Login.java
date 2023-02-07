package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;



public class Login extends AppCompatActivity {

    Button switchToLogin;
    Button switchToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





        switchToLogin = findViewById(R.id.signupbutton);
        switchToLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switchActivity();
            }
        });

        switchToMain = findViewById(R.id.loginbutton);
        switchToMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switchToMainActivity();
            }
        });

    }

    private void switchActivity(){
        Intent switchActivityIntent = new Intent(this, SignUp.class);
        startActivity(switchActivityIntent);
    }

    private void switchToMainActivity(){
        Intent switchMainIntent = new Intent(this,MainActivity.class);
        startActivity(switchMainIntent);
    }

}