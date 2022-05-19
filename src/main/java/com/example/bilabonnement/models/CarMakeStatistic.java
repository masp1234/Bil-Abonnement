package com.example.bilabonnement.models;

public class CarMakeStatistic {
    String carMake;
    int numberOfRentedCars;
    int numberOfAvailableCars;
    int numberOfWorkshopCars;
    double averageLeasePeriod;
    double averagePricerPerMonth;
    String mostPopularModel;
    String mostPopularColor;
    double averageDamagesPerDamageReport;


    public CarMakeStatistic(String carMake, int numberOfRentedCars, int numberOfAvailableCars,
                            int numberOfWorkshopCars, double averageLeasePeriod,
                            double averagePricerPerMonth, String mostPopularModel,
                            String mostPopularColor, double averageDamagesPerDamageReport) {
        this.carMake = carMake;
        this.numberOfRentedCars = numberOfRentedCars;
        this.numberOfAvailableCars = numberOfAvailableCars;
        this.numberOfWorkshopCars = numberOfWorkshopCars;
        this.averageLeasePeriod = averageLeasePeriod;
        this.averagePricerPerMonth = averagePricerPerMonth;
        this.mostPopularModel = mostPopularModel;
        this.mostPopularColor = mostPopularColor;
        this.averageDamagesPerDamageReport = averageDamagesPerDamageReport;
    }
    public CarMakeStatistic() {}


    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public int getNumberOfRentedCars() {
        return numberOfRentedCars;
    }

    public void setNumberOfRentedCars(int numberOfRentedCars) {
        this.numberOfRentedCars = numberOfRentedCars;
    }

    public int getNumberOfAvailableCars() {
        return numberOfAvailableCars;
    }

    public void setNumberOfAvailableCars(int numberOfAvailableCars) {
        this.numberOfAvailableCars = numberOfAvailableCars;
    }

    public int getNumberOfWorkshopCars() {
        return numberOfWorkshopCars;
    }

    public void setNumberOfWorkshopCars(int numberOfWorkshopCars) {
        this.numberOfWorkshopCars = numberOfWorkshopCars;
    }

    public double getAverageLeasePeriod() {
        return averageLeasePeriod;
    }

    public void setAverageLeasePeriod(double averageLeasePeriod) {
        this.averageLeasePeriod = averageLeasePeriod;
    }

    public double getAveragePricerPerMonth() {
        return averagePricerPerMonth;
    }

    public void setAveragePricerPerMonth(double averagePricerPerMonth) {
        this.averagePricerPerMonth = averagePricerPerMonth;
    }

    public String getMostPopularModel() {
        return mostPopularModel;
    }

    public void setMostPopularModel(String mostPopularModel) {
        this.mostPopularModel = mostPopularModel;
    }

    public String getMostPopularColor() {
        return mostPopularColor;
    }

    public void setMostPopularColor(String mostPopularColor) {
        this.mostPopularColor = mostPopularColor;
    }

    public double getAverageDamagesPerDamageReport() {
        return averageDamagesPerDamageReport;
    }

    public void setAverageDamagesPerDamageReport(double averageDamagesPerDamageReport) {
        this.averageDamagesPerDamageReport = averageDamagesPerDamageReport;
    }
}