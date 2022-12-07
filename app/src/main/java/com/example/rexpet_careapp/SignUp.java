package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    RadioButton userbutton;
    RadioButton serviceproviderbutton;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userbutton = findViewById(R.id.userradiobuttontext);
        serviceproviderbutton = findViewById(R.id.serviceproviderradiobuttontext);

    }
       //startActivity(new Intent(this, MainActivity.class));
       //startActivity(new Intent(this,SignupServiceProvider.class));

    public void switchToLogin(View view){
        startActivity(new Intent(this,Login.class));
    }

    public void userradiobuttonselected(View view){
            userbutton.setChecked(true);
            serviceproviderbutton.setChecked(false);
    }

    public void setServiceproviderbuttonselected(View view){
        userbutton.setChecked(false);
        serviceproviderbutton.setChecked(true);
    }

    public void signupcompletion(View view){
            if (userbutton.isChecked() == true){
                startActivity(new Intent(this,MainActivity.class));
            }
            else if(serviceproviderbutton.isChecked() == true){
                startActivity(new Intent(this, SignupServiceProvider.class));
            }

    }
}
