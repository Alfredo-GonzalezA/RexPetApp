package com.example.rexpet_careapp;

public class ServiceProvider {


    private String providerId = "";
    //providerId represents the service provider's unique id in the database

    private String providerName = "";
    //provider name represents the service provider's first name

    private String providerLastName = "";
    //provider name represents the service provider's first name

    private String providerUsername = "";
    //providerUsername represents the service provider's username in the app

    private String providerAddress="";
    //providerAddress stores the service provider's address
    private String providerPassword="";
    //plaintext password. should be encrypted in actual use, but I won't do it for now to make my
    //life easier

    private boolean groomingOffered = false;
    private boolean healthcareOffered = false;
    private boolean walkingOffered = false;
    private boolean sittingOffered = false;
    //booleans that can be used to identify services offered by a specific provider

    public ServiceProvider(){}

    public ServiceProvider(String providerId, String providerName, String providerLastName, String providerUsername, String providerAddress, boolean groomingOffered, boolean healthcareOffered, boolean walkingOffered, boolean sittingOffered, String providerPassword) {
        this.providerId = providerId;
        this.providerName = providerName;
        this.providerLastName = providerLastName;
        this.providerUsername = providerUsername;
        this.providerAddress = providerAddress;
        this.groomingOffered = groomingOffered;
        this.healthcareOffered = healthcareOffered;
        this.walkingOffered = walkingOffered;
        this.sittingOffered = sittingOffered;
        this.providerPassword = providerPassword;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderLastName() {
        return providerLastName;
    }

    public void setProviderLastName(String providerLastName) {
        this.providerLastName = providerLastName;
    }

    public String getProviderUsername() {
        return providerUsername;
    }

    public void setProviderUsername(String providerUsername) {
        this.providerUsername = providerUsername;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public boolean isGroomingOffered() {
        return groomingOffered;
    }

    public void setGroomingOffered(boolean groomingOffered) {
        this.groomingOffered = groomingOffered;
    }

    public boolean isHealthcareOffered() {
        return healthcareOffered;
    }

    public void setHealthcareOffered(boolean healthcareOffered) {
        this.healthcareOffered = healthcareOffered;
    }

    public boolean isWalkingOffered() {
        return walkingOffered;
    }

    public void setWalkingOffered(boolean walkingOffered) {
        this.walkingOffered = walkingOffered;
    }

    public boolean isSittingOffered() {
        return sittingOffered;
    }

    public void setSittingOffered(boolean sittingOffered) {
        this.sittingOffered = sittingOffered;
    }

    protected String getProviderPassword() {
        return providerPassword;
    }

    protected void setProviderPassword(String providerPassword) {
        this.providerPassword = providerPassword;
    }
}
