package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

public class PetSitting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_sitting);

        CalendarView datePicker = (CalendarView) findViewById(R.id.calendarView2);
        datePicker.setMinDate(System.currentTimeMillis() - 1000);
        datePicker.setMaxDate(System.currentTimeMillis() + (1000L *60*60*24*90));
        //end block
    }
    public void switchToMainActivity(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}