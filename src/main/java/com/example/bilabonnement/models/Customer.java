package com.example.bilabonnement.models;

public class Customer {
    private int cpr;
    private int accountNumber;
    private int registrationNumber;
    private String fullName;
    private String email;
    private int phoneNumber;
    private String address;
    private int zipCode;
    private String city;

public Customer() {
}

    public Customer(int cpr, int accountNumber, int registrationNumber, String fullName,
                    String email, int phoneNumber, String address, int zipCode, String city) {
        this.cpr = cpr;
        this.accountNumber = accountNumber;
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCpr() {
        return cpr;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cpr=" + cpr +
                ", accountNumber=" + accountNumber +
                ", registrationNumber=" + registrationNumber +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", zipCode=" + zipCode +
                ", city='" + city + '\'' +
                '}';
    }
}
