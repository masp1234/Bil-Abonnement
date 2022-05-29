package com.example.bilabonnement.models;
/*Martin*/
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

    @Override
    public String toString() {
        return "CarMakeStatistic{" +
                "carMake='" + carMake + '\'' +
                ", numberOfRentedCars=" + numberOfRentedCars +
                ", numberOfAvailableCars=" + numberOfAvailableCars +
                ", numberOfWorkshopCars=" + numberOfWorkshopCars +
                ", averageLeasePeriod=" + averageLeasePeriod +
                ", averagePricerPerMonth=" + averagePricerPerMonth +
                ", mostPopularModel='" + mostPopularModel + '\'' +
                ", mostPopularColor='" + mostPopularColor + '\'' +
                ", averageDamagesPerDamageReport=" + averageDamagesPerDamageReport +
                '}';
    }
}
