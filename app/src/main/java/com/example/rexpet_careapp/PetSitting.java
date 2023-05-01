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
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.List;

public class PetSitting extends AppCompatActivity {


    Button ps_timeButton;
    int ps_hour, ps_minute, year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_sitting);

//        CalendarView datePicker = (CalendarView) findViewById(R.id.calendarView2);
//        datePicker.setMinDate(System.currentTimeMillis() - 1000);
//        datePicker.setMaxDate(System.currentTimeMillis() + (1000L *60*60*24*90));

        Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        CalendarPickerView datePicker = findViewById(R.id.ps_calendarView);
        datePicker.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(today);



        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                //String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);

                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);

                String selectedDate = "" + (calSelected.get(Calendar.MONTH) + 1)
                        + " " + calSelected.get(Calendar.DAY_OF_MONTH)
                        + " " + calSelected.get(Calendar.YEAR);

                ArrayList<Date> dateRange = new ArrayList<>(0);

                dateRange.addAll(datePicker.getSelectedDates());

                String startDate = dateRange.get(0).toString();
                String endDate = dateRange.get(dateRange.size() - 1).toString();

                DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
//                String startDate = dateFormat.format(dateRange.get(0));
//                String endDate = dateFormat.format(dateRange.get(dateRange.size() - 1));

                //Toast.makeText(PetSitting.this, selectedDate, Toast.LENGTH_SHORT).show();
                Toast.makeText(PetSitting.this, startDate + " - " + endDate, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
        //end block
    }
    public void switchToMainActivity(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void switchToSetLocation(View view){
        startActivity(new Intent(this,SetLocation.class));
    }

    public void popupTimeClicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                ps_hour = selectedHour;
                ps_minute = selectedMinute;
                ps_timeButton = findViewById(R.id.ps_time_picker_button);
                if(ps_hour > 12){
                    ps_timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d PM", ps_hour %12, ps_minute));
                }else if(ps_hour == 0){
                    ps_timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d AM", 12, ps_minute));
                }else if(ps_hour == 12){
                    ps_timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d PM", 12, ps_minute));
                }else {
                    ps_timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d AM", ps_hour, ps_minute));
                }

            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, ps_hour, ps_minute, false);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}