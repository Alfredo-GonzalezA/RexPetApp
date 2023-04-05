package com.example.rexpet_careapp;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId = "";
    //userId refers to the unique id generated automatically for a user's account by Firebase Auth
    private String email ="example@example.com";
    //stores user's email for ease of access
    private String fName = "";
    //refers to user's first name
    private String lName = "";
    //refers to user's last name
    private String address = "";
    //user's street address
    private List<String> userPets = new ArrayList<String>();
    //list of the user's pets, stored as their unique ids for ease of access in the database

    public User(String userId, String email, String fName, String lName, String address, List <String> userPets){
        setUserId(userId);
        setEmail(email);
        setfName(fName);
        setlName(lName);
        setAddress(address);
        setUserPets(userPets);
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getUserPets() {
        return userPets;
    }

    public void setUserPets(List<String> userPets) {
        this.userPets = userPets;
    }
}
