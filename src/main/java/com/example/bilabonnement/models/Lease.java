package com.example.bilabonnement.models;

public class Lease {

    private int price;
    private int periode; /*Denne ændres nok senere*/
    private String carRegistrationNumber;
    private String customerCprNumber;


    public Lease() {

    }

    public Lease(int price, int periode, String carRegistrationNumber, String customerCprNumber) {
        this.price = price;
        this.periode = periode;
        this.carRegistrationNumber = carRegistrationNumber;
        this.customerCprNumber = customerCprNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public String getCustomerCprNumber() {
        return customerCprNumber;
    }

    public void setCustomerCprNumber(String customerCprNumber) {
        this.customerCprNumber = customerCprNumber;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "price=" + price +
                ", periode=" + periode +
                ", carRegistrationNumber='" + carRegistrationNumber + '\'' +
                ", customerCprNumber=" + customerCprNumber +
                '}';
    }
}