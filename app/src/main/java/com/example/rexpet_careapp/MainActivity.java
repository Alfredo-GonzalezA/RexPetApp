package com.example.rexpet_careapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageButton switchToHealthCare;
    ImageButton switchToGrooming;
    ImageButton switchToWalking;
    ImageButton switchToPetSitting;
    Button switchToAddPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner = findViewById(R.id.mypetsspinnermain);
        // Get a reference to the "Pets" node in the database
        DatabaseReference petsRef = FirebaseDatabase.getInstance().getReference("Pets");

// Add a ValueEventListener to retrieve the pet names
        petsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> petNames = new ArrayList<>();

                // Iterate over the pets and add their names to the list
                for (DataSnapshot petSnapshot : dataSnapshot.getChildren()) {
                    String petName = petSnapshot.child("name").getValue(String.class);
                    if (petName != null) {
                        petNames.add(petName);
                    }
                }

                // Do something with the list of pet names (e.g., populate a spinner)
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, petNames);
                spinner.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "Failed to read value.", databaseError.toException());
            }
        });


// Add the listener to the database reference


        //--------------------------------------------------------------------


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