package com.example.rexpet_careapp;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPet extends AppCompatActivity {
    Button addPetButton;
    EditText petNameView;
    ArrayAdapter<String> breedsArrayAdapter;
    AutoCompleteTextView petBreedView;
    RadioGroup genderSelector;
    RadioButton selectedButton;
    EditText petAgeView;
    EditText petWeightView;

    //variables for user
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid = user.getUid();

    DatabaseReference databasePets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        databasePets = FirebaseDatabase.getInstance().getReference("Pets");

        addPetButton = (Button) findViewById(R.id.addServiceProviderButton);
        petNameView = (EditText) findViewById(R.id.addServiceProviderNameField);

        breedsArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, BREEDS);
        petBreedView = (AutoCompleteTextView)
                findViewById(R.id.addBreedAutoComplete);
        petBreedView.setAdapter(breedsArrayAdapter);//sets up auto complete for dog breeds

        genderSelector = (RadioGroup) findViewById(R.id.maleFemaleRadioGroup);
        petAgeView = (EditText) findViewById(R.id.addPetAgeField);
        petWeightView = (EditText) findViewById(R.id.addPetWeightField);

        addPetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addPet();
            }
        });
    }

    private void addPet(){
        //variables for pet
        String name = petNameView.getText().toString().trim();
        String breed = petBreedView.getText().toString().trim();
        double age = parseDouble(petAgeView.getText().toString().trim());
        double weight = parseDouble(petWeightView.getText().toString().trim());
        int selectedRadio = genderSelector.getCheckedRadioButtonId();
        selectedButton = (RadioButton) findViewById(selectedRadio);
        String gender = (String) selectedButton.getText();



        //!!!! need to find way to actually validate input !!!!
        if((!TextUtils.isEmpty(name)) && !TextUtils.isEmpty(breed)){
            String id = databasePets.push().getKey();

            //just putting user here for the sake of testing for now.

            if(user != null){
                Context context = getApplicationContext();
                CharSequence text = "Successfully retrieved user data";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
            }else{
                Context context = getApplicationContext();
                CharSequence text = "Unable to get user.";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
            }

            //NEED TO FIND WAY TO GET USER'S ID BASED ON SIGN IN
            Pet pet = new Pet(id, uid, name, breed, gender, age, weight);
            databasePets.child(id).setValue(pet);
            petNameView.setText("");
            petBreedView.setText("");
            genderSelector.clearCheck();
            petAgeView.setText("");
            petWeightView.setText("");

        }
        Toast.makeText(this, "Pet added", Toast.LENGTH_LONG).show();//debugging

            startActivity(new Intent(this,MainActivity.class));

    }
    public void switchToMainActivity(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

    private static final String[] BREEDS = new String[] {
            "Corgi", "Husky", "German Shepherd", "Labrador", "Maltese"
    };


}