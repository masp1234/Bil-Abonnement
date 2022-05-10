package com.example.bilabonnement.models;

public class Car {
    private String chassisNumber;
    private String make;
    private String model;
    private String color;
    private String registrationNumber;
    private String equipmentLevel;
    private double registrationFee;
    private double emission;
    private boolean isAvailable = false;
    private boolean isRdyToRent = true;


    public Car() {
    }

    public Car(String registrationNumber, String chassisNumber, String make, String model, String color,
               String equipmentLevel, double registrationFee, double emission, boolean isAvailable, boolean isRdyToRent) {
        this.registrationNumber = registrationNumber;
        this.chassisNumber = chassisNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.registrationFee = registrationFee;
        this.equipmentLevel = equipmentLevel;
        this.emission = emission;
        this.isAvailable = isAvailable;
        this.isRdyToRent = isRdyToRent;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }
    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public String getEquipmentLevel() {
        return equipmentLevel;
    }

    public void setEquipmentLevel(String equipmentLevel) {
        this.equipmentLevel = equipmentLevel;
    }

    public double getEmission() {
        return emission;
    }

    public void setEmission(double emission) {
        this.emission = emission;
    }



    @Override
    public String toString() {
        return "Car{" +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", equipmentLevel='" + equipmentLevel + '\'' +
                ", registrationFee=" + registrationFee +
                ", emission=" + emission +
                '}';
    }
}
