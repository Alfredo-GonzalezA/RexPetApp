package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Walking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);
    }
    public void switchToMainActivity(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}