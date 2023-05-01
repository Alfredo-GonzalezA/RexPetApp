package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;

import java.util.Locale;

public class Walking extends AppCompatActivity {

    Button w_start_timeButton;
    Button w_end_timeButton;
    int w_start_hour, w_start_minute, year, month, day;
    int w_end_hour, w_end_minute, w_end_year, w_end_month, w_end_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);


        CalendarView datePicker = (CalendarView) findViewById(R.id.w_calendarView);
        datePicker.setMinDate(System.currentTimeMillis() - 1000);
        datePicker.setMaxDate(System.currentTimeMillis() + (1000L *60*60*24*90));
        //end block
    }
    public void switchToMainActivity(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void w_switchToSetLocation(View view){
        startActivity(new Intent(this,SetLocation.class));
    }

    public void popupStartTimeClicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                w_start_hour = selectedHour;
                w_start_minute = selectedMinute;
                w_start_timeButton = findViewById(R.id.w_start_time);
                if(w_start_hour > 12){
                    w_start_timeButton.setText(String.format(Locale.getDefault(), "Start: %02d:%02d PM", w_start_hour %12, w_start_minute));
                }else if(w_start_hour == 0){
                    w_start_timeButton.setText(String.format(Locale.getDefault(), "Start: %02d:%02d AM", 12, w_start_minute));
                }else if(w_start_hour == 12){
                    w_start_timeButton.setText(String.format(Locale.getDefault(), "Start: %02d:%02d PM", 12, w_start_minute));
                }else {
                    w_start_timeButton.setText(String.format(Locale.getDefault(), "Start: %02d:%02d AM", w_start_hour, w_start_minute));
                }

            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, w_start_hour, w_start_minute, false);
        timePickerDialog.setTitle("Select Start Time");
        timePickerDialog.show();
    }

    public void popupEndTimeClicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                w_end_hour = selectedHour;
                w_end_minute = selectedMinute;
                w_end_timeButton = findViewById(R.id.w_end_time);
                if(w_end_hour > 12){
                    w_end_timeButton.setText(String.format(Locale.getDefault(), "End: %02d:%02d PM", w_end_hour %12, w_end_minute));
                }else if(w_end_hour == 0){
                    w_end_timeButton.setText(String.format(Locale.getDefault(), "End: %02d:%02d AM", 12, w_end_minute));
                }else if(w_end_hour == 12){
                    w_end_timeButton.setText(String.format(Locale.getDefault(), "End: %02d:%02d PM", 12, w_end_minute));
                }else {
                    w_end_timeButton.setText(String.format(Locale.getDefault(), "End: %02d:%02d AM", w_end_hour, w_end_minute));
                }

            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, w_end_hour, w_end_minute, false);
        timePickerDialog.setTitle("Select End Time");
        timePickerDialog.show();
    }
}