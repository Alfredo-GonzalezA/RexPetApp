package com.example.rexpet_careapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton switchToHealthCare;
    ImageButton switchToGrooming;
    ImageButton switchToWalking;
    ImageButton switchToPetSitting;
    Button switchToAddPet;
    int changeWorked;
    String testString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//----------------------------------------------------------------------------------
        //this block is to add pets to the spinner(dropdown menu)
        ArrayList<String> ownerpetarraylist = new ArrayList<>();
        Spinner ownerpetspinner = (Spinner) findViewById(R.id.mypetsspinnermain);

        ownerpetarraylist.add("My Pets");
        ownerpetarraylist.add("Daisy");
        ArrayAdapter<String> ownerpetadaptor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ownerpetarraylist);
        ownerpetadaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ownerpetspinner.setAdapter(ownerpetadaptor);
        ownerpetspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//-------------------------------------------------------------------------------------

        switchToHealthCare = findViewById(R.id.healthcarebutton);
        switchToHealthCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToHealthCareActivity();
            }
        });


        //button functions to go to the 4 main features
        switchToGrooming = findViewById(R.id.groomingbutton);
        switchToGrooming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToGroomingActivity();
            }
        });

        switchToWalking = findViewById(R.id.dogwalkingbutton);
        switchToWalking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToWalkingActivity();
            }
        });

        switchToPetSitting = findViewById(R.id.petsittingbutton);
        switchToPetSitting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToPetSittingActivity();
            }
        });

        switchToAddPet = (Button) findViewById(R.id.addpetbutton);
        switchToAddPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToAddPetActivity();
            }
        });

    }


    //end button functions

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");






    public void firebasedebug(View view){
        myRef.setValue("Hello World ");

    }


    public void switchToAddPetActivity(){
        startActivity(new Intent(this,AddPet.class));
    }

    private void switchToHealthCareActivity(){
        Intent switchHealthCareIntent = new Intent(this,Healthcare.class);
        startActivity(switchHealthCareIntent);
    }

    private void switchToGroomingActivity() {
        Intent switchGroomingIntent = new Intent(this,Grooming.class);
        startActivity(switchGroomingIntent);
    }

    private void switchToWalkingActivity() {
        Intent switchWalkingIntent = new Intent(this,Walking.class);
        startActivity(switchWalkingIntent);
    }

    private void switchToPetSittingActivity() {
        Intent switchPetSittingIntent = new Intent(this,PetSitting.class);
        startActivity(switchPetSittingIntent);
    }
    public void switchToLogin(View view){
        startActivity(new Intent(this,Login.class));}


    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

}