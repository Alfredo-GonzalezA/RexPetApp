package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FindAndSelectServiceProvider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_and_select_service_provider);

    }
    public void switchToMainActivity(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void switchToServiceProviderInfoActivity(View view){
        startActivity(new Intent(this, ServiceProviderInformation.class));
    }

    public void gotopayment(View view){
        startActivity(new Intent(this, Payment.class));
    }


}
