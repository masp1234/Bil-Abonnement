package com.example.bilabonnement.models;

public class Damage {
    private int damageId;
    private String description;
    private int price;
    private int damageReportId;

    public Damage(int damageId, String description, int price) {
        this.damageId = damageId;
        this.description = description;
        this.price = price;
    }

    public Damage(String description, int price, int damageReportId) {
        this.description = description;
        this.price = price;
        this.damageReportId= damageReportId;
    }

    public int getDamageReportId() {
        return damageReportId;
    }

    public void setDamageReportId(int damageReportId) {
        this.damageReportId = damageReportId;
    }

    public int getDamageId() {
        return damageId;
    }

    public void setDamageId(int damageId) {
        this.damageId = damageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

