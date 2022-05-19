package com.example.bilabonnement.models;

import java.util.Date;

public class DamageReport {

    private int id;
    private Date date;
    private String description;
    private String chassisNumber;
    private int totalPrice;

    public DamageReport(int id, Date date, String description, String chassisNumber, int totalPrice) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.chassisNumber = chassisNumber;
        this.totalPrice = totalPrice;
    }

    public DamageReport(Date date, String description, String chassisNumber) {
        this.date = date;
        this.description = description;
        this.chassisNumber = chassisNumber;
    }

    public DamageReport() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    @Override
    public String toString() {
        return "DamageReport{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                '}';
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}