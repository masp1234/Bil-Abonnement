package com.example.bilabonnement.models;

public class Lease {

    private String accountRegistrationNumber;
    private String accountNumber;
    private int price;
    private int periode; /*Denne ændres nok senere*/
    private String carRegistrationNumber;
    private int customerCprNumber;


    public Lease() {

    }

    public Lease(String accountRegistrationNumber, String accountNumber, int price,
                 int periode, String carRegistrationNumber, int customerCprNumber) {
        this.accountRegistrationNumber = accountRegistrationNumber;
        this.accountNumber = accountNumber;
        this.price = price;
        this.periode = periode;
        this.carRegistrationNumber = carRegistrationNumber;
        this.customerCprNumber = customerCprNumber;
    }

    public String getAccountRegistrationNumber() {
        return accountRegistrationNumber;
    }

    public void setAccountRegistrationNumber(String accountRegistrationNumber) {
        this.accountRegistrationNumber = accountRegistrationNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public int getCustomerCprNumber() {
        return customerCprNumber;
    }

    public void setCustomerCprNumber(int customerCprNumber) {
        this.customerCprNumber = customerCprNumber;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "accountRegistrationNumber='" + accountRegistrationNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", price=" + price +
                ", periode=" + periode +
                ", carRegistrationNumber='" + carRegistrationNumber + '\'' +
                ", customerCprNumber=" + customerCprNumber +
                '}';
    }
}