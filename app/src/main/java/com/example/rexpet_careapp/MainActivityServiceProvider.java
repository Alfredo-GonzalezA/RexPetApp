package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityServiceProvider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service_provider);

        Button appointmentsButton = findViewById(R.id.appointments_button);
        appointmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityServiceProvider.this, AppointmentsActivity.class);
                //appointment details which need to be changed to database info
                intent.putExtra("date", "2023-04-25");
                intent.putExtra("name", "John Doe");
                intent.putExtra("status", "Incomplete");
                intent.putExtra("Service","Grooming");
                startActivity(intent);
            }
        });

        Button historyButton = findViewById(R.id.history_button);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityServiceProvider.this, HistoryActivity.class);
                //appointment details which need to be changed to database info
                intent.putExtra("date", "2023-04-20");
                intent.putExtra("name", "Lexi Zayn");
                intent.putExtra("status", "Complete");
                intent.putExtra("price", "$20");
                intent.putExtra("Service","Grooming");
                startActivity(intent);
            }
        });


    }
    public void login(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }

}