package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    EditText firstNameView;
    EditText lastNameView;
    EditText emailView;
    EditText passwordView;
    TextView addressView;
    TextView cityView;
    TextView stateView;
    TextView zipView;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;

    RadioButton userbutton;
    RadioButton serviceproviderbutton;
    private FirebaseAuth mAuth;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$");
    private static final Pattern ALPHA_PATTERN = Pattern.compile("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//        mAuth = FirebaseAuth.getInstance();
//
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            finish();
//            startActivity(getIntent());
//        }

        userbutton = findViewById(R.id.userradiobuttontext);
        serviceproviderbutton = findViewById(R.id.serviceproviderradiobuttontext);

        firstNameView = findViewById(R.id.signupfirstnametext);
        lastNameView = findViewById(R.id.signuplastnametext);
        emailView = findViewById(R.id.signupemailtext);
        passwordView = findViewById(R.id.signuppasswordtext);
        addressView = findViewById(R.id.signupaddresstext);
        cityView = findViewById(R.id.signupcitytext);
        stateView = findViewById(R.id.signupstatetext);
        zipView = findViewById(R.id.signupziptext);

        //still need to check if user already exists
        findViewById(R.id.signupbuttontext).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                email = emailView.getText().toString();
                password = passwordView.getText().toString();
                firstName = firstNameView.getText().toString();
                lastName = lastNameView.getText().toString();
                email = emailView.getText().toString();
                password = passwordView.getText().toString();
                address = addressView.getText().toString();
                city = cityView.getText().toString();
                state = stateView.getText().toString();
                zip = zipView.getText().toString();

                Matcher passwordMatcher = PASSWORD_PATTERN.matcher(password);
                Matcher alphaMatcher = ALPHA_PATTERN.matcher(firstName);


                //also should have error checking for when there is actual invalid input
                //currently only checks if fields are empty
                if(TextUtils.isEmpty(email)){
                    emailView.setError("Please enter an email!");
                    emailView.setBackgroundResource(R.drawable.edittext_error_background);
                }else if(!isEmailValid(email)){
                    emailView.setError("Please enter a valid email!");
                    emailView.setBackgroundResource(R.drawable.edittext_error_background);
                }else{
                    emailView.setBackgroundResource(R.drawable.edittext_normal_background);
                }

                if(TextUtils.isEmpty(password)){
                    passwordView.setError("Please enter a password!");
                    passwordView.setBackgroundResource(R.drawable.edittext_error_background);
                }else if(!passwordMatcher.matches()){
                    passwordView.setError("Please enter a valid password!\n" +
                            "A valid password has:\n" +
                            "Between 8 and 20 characters,\n" +
                            "at least one uppercase and one lowercase letter,\n" +
                            "at least one number,\n" +
                            "at least one special character from the following list: @#$%^&+="
                    );
                    passwordView.setBackgroundResource(R.drawable.edittext_error_background);
                }else{
                    passwordView.setBackgroundResource(R.drawable.edittext_normal_background);
                }

                if(TextUtils.isEmpty(firstName) || !alphaMatcher.matches()){
                    firstNameView.setError("Please enter a first name!");
                    firstNameView.setBackgroundResource(R.drawable.edittext_error_background);
                }else{
                    firstNameView.setBackgroundResource(R.drawable.edittext_normal_background);
                }

                alphaMatcher = ALPHA_PATTERN.matcher(lastName);
                if(TextUtils.isEmpty(lastName) || !alphaMatcher.matches()){
                    lastNameView.setError("Please enter a first name!");
                    lastNameView.setBackgroundResource(R.drawable.edittext_error_background);
                }else{
                    lastNameView.setBackgroundResource(R.drawable.edittext_normal_background);
                }



                if(TextUtils.isEmpty(firstName)){
                    Toast.makeText(getApplicationContext(), "First Name is empty", Toast.LENGTH_SHORT);
                }
                if(TextUtils.isEmpty(lastName)){
                    Toast.makeText(getApplicationContext(), "Last Name is empty", Toast.LENGTH_SHORT);
                }
            }
        });
    }
       //startActivity(new Intent(this, MainActivity.class));
       //startActivity(new Intent(this,SignupServiceProvider.class));

    public void switchToLogin(View view){
        startActivity(new Intent(this,Login.class));
    }

    boolean isEmailValid(CharSequence email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
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
