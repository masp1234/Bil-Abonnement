package com.example.bilabonnement.models;

public class Car {
    private int id;
    private String chassisNumber;
    private String make;
    private String model;
    private String color;
    private String registrationNumber;
    private String equipmentLevel;
    private double registrationFee;
    private double emission;
    private int leaseId;

    public Car(int id, String chassisNumber, String make, String model, String color,
               String registrationNumber, String equipmentLevel,
               double registrationFee, double emission, int leaseId) {
        this.id = id;
        this.chassisNumber = chassisNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.registrationFee = registrationFee;
        this.equipmentLevel = equipmentLevel;
        this.emission = emission;
        this.leaseId = leaseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(int leaseId) {
        this.leaseId = leaseId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", equipmentLevel='" + equipmentLevel + '\'' +
                ", registrationFee=" + registrationFee +
                ", emission=" + emission +
                ", leaseId=" + leaseId +
                '}';
    }
}
