package com.example.bilabonnement.models;
/*Danny
* Martin
* Daniel*/

public class Lease {

    private int pricePerMonth;
    private String startDate;
    private String endDate;
    private String carRegistrationNumber;
    private String customerCprNumber;
    private String customerRegNumber;
    private String customerAccountNumber;


    public Lease() {

    }

    public Lease(int price, String startDate, String endDate, String carRegistrationNumber, String customerCprNumber, String customerAccountNumber, String customerRegNumber) {
        this.pricePerMonth = price;
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

    public int getPricePerMonth() {
        return pricePerMonth;
    }


    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }


    public String getCustomerCprNumber() {
        return customerCprNumber;
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
                "price=" + pricePerMonth +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", carRegistrationNumber='" + carRegistrationNumber + '\'' +
                ", customerCprNumber='" + customerCprNumber + '\'' +
                ", customerRegNumber='" + customerRegNumber + '\'' +
                ", customerAccountNumber='" + customerAccountNumber + '\'' +
                '}';
    }
}