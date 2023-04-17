package com.example.rexpet_careapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FirebaseUtils {

    private static DatabaseReference database;

    public static DatabaseReference getDatabase() {
        if (database == null) {
            database = FirebaseDatabase.getInstance().getReference("users");
        }
        return database;
    }

    public static String generateKey() {
        return getDatabase().push().getKey();
    }
}
