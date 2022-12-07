package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Locale;

public class Grooming extends AppCompatActivity {
    Button timeButton;
    int hour, minute;
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
        timeButton = findViewById(R.id.time_picker_button);
    }

    public void switchToMainActivity(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void continues(View view){
        startActivity(new Intent(this,FindAndSelectServiceProvider.class));
    }

    public void popupTimeClicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                if(hour > 12){
                    timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d PM", hour%12, minute));
                }else if(hour == 0){
                    timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d AM", 12, minute));
                }else if(hour == 12){
                    timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d PM", 12, minute));
                }else {
                    timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d AM", hour, minute));
                }

            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, false);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}