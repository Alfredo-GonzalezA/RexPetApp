package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Get appointment details from intent extras
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        String name = intent.getStringExtra("name");
        String status = intent.getStringExtra("status");
        String price = intent.getStringExtra("price");

        // Update UI with appointment details
        TextView dateTextView = findViewById(R.id.appointment_date);
        dateTextView.setText("Date: " + date);
        TextView nameTextView = findViewById(R.id.appointment_name);
        nameTextView.setText("Name: " + name);
        TextView statusTextView = findViewById(R.id.appointment_status);
        statusTextView.setText("Status: " + status);
        TextView priceTextView = findViewById(R.id.appointment_price);
        priceTextView.setText("Price: " + price);
    }
    public void swithtospmain(View view){
        startActivity(new Intent(this, MainActivityServiceProvider.class));
    }
}