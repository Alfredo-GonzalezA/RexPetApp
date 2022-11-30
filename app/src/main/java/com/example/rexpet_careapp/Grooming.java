package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Grooming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming);


        //this block of code is to add the spinner options for the types of grooming
        ArrayList<String> groomingarraylist = new ArrayList<>();
        Spinner groomingspinner = (Spinner) findViewById(R.id.groomingspinner);
        groomingarraylist.add("Haircut");
        groomingarraylist.add("Bathing");
        groomingarraylist.add("Nail trimming");
        groomingarraylist.add("Full Package");

        ArrayAdapter<String> groomingadaptor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, groomingarraylist);
        groomingadaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        groomingspinner.setAdapter(groomingadaptor);
        groomingspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //end block of code for spinner

    }

    public void switchToMainActivity(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void continues(View view){
        startActivity(new Intent(this,FindAndSelectServiceProvider.class));
    }
}