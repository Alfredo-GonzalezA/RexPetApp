package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton switchToHealthCare;
    ImageButton switchToGrooming;
    ImageButton switchToWalking;
    ImageButton switchToPetSitting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchToHealthCare = findViewById(R.id.healthcarebutton);
        switchToHealthCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToHealthCareActivity();
            }
        });


        //button functions to go to the 4 main features
        switchToGrooming = findViewById(R.id.groomingbutton);
        switchToGrooming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToGroomingActivity();
            }
        });

        switchToWalking = findViewById(R.id.dogwalkingbutton);
        switchToWalking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToWalkingActivity();
            }
        });

        switchToPetSitting = findViewById(R.id.petsittingbutton);
        switchToPetSitting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToPetSittingActivity();
            }
        });
    }
    //end button functions


    private void switchToHealthCareActivity(){
        Intent switchHealthCareIntent = new Intent(this,Healthcare.class);
        startActivity(switchHealthCareIntent);
    }

    private void switchToGroomingActivity() {
        Intent switchGroomingIntent = new Intent(this,Grooming.class);
        startActivity(switchGroomingIntent);
    }

    private void switchToWalkingActivity() {
        Intent switchWalkingIntent = new Intent(this,Walking.class);
        startActivity(switchWalkingIntent);
    }

    private void switchToPetSittingActivity() {
        Intent switchPetSittingIntent = new Intent(this,PetSitting.class);
        startActivity(switchPetSittingIntent);
    }


}