package com.example.bilabonnement.models;


public class Lease {

    private int price;
    private String startDate;
    private String endDate;
    private String carRegistrationNumber;
    private String customerCprNumber;
    private String customerRegNumber;
    private String customerAccountNumber;


    public Lease() {

    }

    public Lease(int price, String startDate, String endDate, String carRegistrationNumber, String customerCprNumber, String customerAccountNumber, String customerRegNumber) {
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
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


    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", carRegistrationNumber='" + carRegistrationNumber + '\'' +
                ", customerCprNumber='" + customerCprNumber + '\'' +
                ", customerRegNumber='" + customerRegNumber + '\'' +
                ", customerAccountNumber='" + customerAccountNumber + '\'' +
                '}';
    }
}