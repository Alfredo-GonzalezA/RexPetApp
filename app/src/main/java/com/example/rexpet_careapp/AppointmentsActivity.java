package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class AppointmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        // Get appointment details from intent extras
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        String name = intent.getStringExtra("name");
        String status = intent.getStringExtra("status");

        // Update UI with appointment details
        TextView dateTextView = findViewById(R.id.appointment_date);
        dateTextView.setText("Date: " + date);
        TextView nameTextView = findViewById(R.id.appointment_name);
        nameTextView.setText("Name: " + name);
        TextView statusTextView = findViewById(R.id.appointment_status);
        statusTextView.setText("Status: " + status);
    }
    public void swithtospmain(View view){
        startActivity(new Intent(this, MainActivityServiceProvider.class));
    }
}