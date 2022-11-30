package com.example.rexpet_careapp;

public class Pet {

    private String userId = "";
    //userId represents the pet's owner
    private String petId = "";
    //petId represents a particular instance of the pet, used as primary key in database
    private String name = "";
    private String breed = "";
    //represents pet breed Husky, German Shepherd, etc
    private String gender = "";
    //male or female
    private double age = 0.0;
    //age in years, represented as double so user can represent 1.5 years, 8 months, etc
    private double weight = 0.0;

    public Pet(){}

    public Pet(String petId, String userId, String name, String breed, String gender, double age, double weight) {
        this.petId = petId;
        this.userId = userId;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }

    public String getGender() {
        return gender;
    }

    public double getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getUserId() {
        return userId;
    }

    public String getPetId() {
        return petId;
    }
}
