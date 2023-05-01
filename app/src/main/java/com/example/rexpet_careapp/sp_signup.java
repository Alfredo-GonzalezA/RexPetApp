package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sp_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_signup);
    }

    public void switchtonextsp(View view){
        startActivity(new Intent(this,SignupServiceProvider.class));
    }
    public void login(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }
}