package com.example.bilabonnement.models;

import java.util.Date;

public class DamageReport {

    private int id;
    private Date date; /*Er det overhovedet rigtigt?*/
    private String description;
    private String chassisNumber;

    public DamageReport(int id, Date date, String description, String chassisNumber) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.chassisNumber = chassisNumber;
    }

    public DamageReport(Date date, String description, String chassisNumber) {
        this.date = date;
        this.description = description;
        this.chassisNumber = chassisNumber;
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
}
/*
if now > enddate
Træk data ud. */