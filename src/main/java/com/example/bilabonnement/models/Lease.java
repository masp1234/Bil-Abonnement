package com.example.bilabonnement.models;

public class Lease {

    private int price;
    private int period; /*Denne ændres nok senere*/
    private String carRegistrationNumber;
    private String customerCprNumber;
    private String customerRegNumber;
    private String customerAccountNumber;


    public Lease() {

    }

    public Lease(int price, int period, String carRegistrationNumber, String customerCprNumber, String customerAccountNumber, String customerRegNumber) {
        this.price = price;
        this.period = period;
        this.carRegistrationNumber = carRegistrationNumber;
        this.customerCprNumber = customerCprNumber;
        this.customerAccountNumber = customerAccountNumber;
        this.customerRegNumber = customerRegNumber;
    }

    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public String getCustomerRegNumber() {
        return customerRegNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
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
                ", periode=" + period +
                ", carRegistrationNumber='" + carRegistrationNumber + '\'' +
                ", customerCprNumber=" + customerCprNumber +
                '}';
    }
}