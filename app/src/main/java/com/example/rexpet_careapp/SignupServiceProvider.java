package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignupServiceProvider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_service_provider);
    }

    public void start(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void login(View view){
        startActivity(new Intent(this, Login.class));
    }
}