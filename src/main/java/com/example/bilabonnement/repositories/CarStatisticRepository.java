package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.CarMakeStatistic;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CarStatisticRepository {

    Connection connection;

    public CarStatisticRepository() {
        this.connection = ConnectionManager.connectToMySQL();
    }

    /*Martin
    * Daniel*/
    public List<CarMakeStatistic> getCarMakes() {
        List<CarMakeStatistic> carMakeStatistics = new ArrayList<>();
        String query = "SELECT DISTINCT car_make from car ORDER BY car_make ASC";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String carMake = resultSet.getString(1);
                CarMakeStatistic carMakeStatistic = new CarMakeStatistic();
                carMakeStatistic.setCarMake(carMake);
                carMakeStatistics.add(carMakeStatistic);
            }
        } catch (SQLException e) {
            System.out.println("Kunne ikke finde car_makes i car table");
            e.printStackTrace();
        }
        return carMakeStatistics;
    }

    /*Martin
    * Jarl*/
    public HashMap<String, HashMap<String, Integer>> getCarMakesAndStatus() {

        String query = "SELECT car.car_make, cars_available.available, cars_reserved.reserved, cars_in_workshop.workshop\n" +
                "FROM car\n" +
                "LEFT JOIN \n" +
                "((SELECT car_make, COUNT(*) AS available FROM car WHERE car_status = 'available' GROUP BY car_make) AS cars_available)\n" +
                "ON car.car_make = cars_available.car_make\n" +
                "LEFT JOIN\n" +
                "((SELECT car_make, COUNT(*) AS reserved FROM car WHERE car_status = 'reserved' GROUP BY car_make) AS cars_reserved)\n" +
                "ON car.car_make = cars_reserved.car_make\n" +
                "LEFT JOIN\n" +
                "((SELECT car_make, COUNT(*) AS workshop FROM car WHERE car_status = 'workshop' GROUP BY car_make) AS cars_in_workshop)\n" +
                "ON car.car_make = cars_in_workshop.car_make\n" +
                "GROUP BY car.car_make\n" +
                "\n";
        HashMap<String, HashMap<String, Integer>> list = new HashMap<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String carMake = resultSet.getString(1);
                int availableCars = resultSet.getInt(2);
                int reservedCars = resultSet.getInt(3);
                int workshopCars = resultSet.getInt(4);
                list.put(carMake, new HashMap<>());

                //Indeholder metadata, som f.eks. column navne
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                list.get(carMake).put(resultSetMetaData.getColumnName(2), availableCars);
                list.get(carMake).put(resultSetMetaData.getColumnName(3), reservedCars);
                list.get(carMake).put(resultSetMetaData.getColumnName(4), workshopCars);
            }
        } catch (SQLException e) {
            System.out.println("Kunne ikke kalde getCarMakesAndStatus");
            e.printStackTrace();
        }
        return list;
    }

    /*Martin*/
    public List<Double> getAverageLeasePeriodsPerCarMake() {
        List<Double> averageLeasePeriodsPerCarMake = new ArrayList<>();

        String query = "SELECT car_make, AVG(DATEDIFF(lease_end_date, lease_start_date)) as average_date_diff \n" +
                "FROM car \n" +
                "LEFT JOIN lease on car_reg_number = lease_car_reg_number\n" +
                "GROUP BY car_make\n" +
                "ORDER BY car_make\n";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                double averageLeasePeriod = resultSet.getDouble(2);
                averageLeasePeriodsPerCarMake.add(averageLeasePeriod);
            }
        } catch (SQLException e) {
            System.out.println("Kunne ikke finde gennemsnitlige lease perioder per bilmærke");
            e.printStackTrace();
        }
        return averageLeasePeriodsPerCarMake;
    }

    /*Martin*/
    public List<Double> getAverageLeasePricePerMonthPerCarMake() {
        List<Double> averageLeasePricePerMonthPerCarMake = new ArrayList<>();

        String query = "SELECT car_make, AVG(lease_price) as price_per_month \n" +
                "FROM car \n" +
                "LEFT JOIN lease \n" +
                "ON car_reg_number = lease_car_reg_number\n" +
                "GROUP BY car_make\n" +
                "ORDER BY car_make\n";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                double averagePricePerMonth = resultSet.getDouble(2);
                averageLeasePricePerMonthPerCarMake.add(averagePricePerMonth);
            }
        } catch (SQLException e) {
            System.out.println("Kunne ikke finde gennesnitlige leasingpris per måned per bilmærke");
            e.printStackTrace();
        }
        return averageLeasePricePerMonthPerCarMake;
    }

    /*Martin*/
    public List<Car> getAllCarsByCarMake(String carMake) {
        List<Car> allCarsByCarMake = new ArrayList<>();

        String query = "SELECT * FROM car WHERE car_make = '" + carMake + "'";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String registrationNumber = resultSet.getString(1);
                String chassisNumber = resultSet.getString(2);
                String make = resultSet.getString(3);
                String model = resultSet.getString(4);
                String color = resultSet.getString(5);
                String equipmentLevel = resultSet.getString(6);
                double registrationFee = resultSet.getDouble(7);
                double emission = resultSet.getDouble(8);
                String status = resultSet.getString(9);
                String url = resultSet.getString(10);

                allCarsByCarMake.add(new Car(registrationNumber, chassisNumber, make, model,
                        color, equipmentLevel,
                        registrationFee, emission, status, url));
            }

        } catch (SQLException e) {
            System.out.println("kunne ikke finde alle biler med bilmærket: " + carMake);
            e.printStackTrace();
        }
        return allCarsByCarMake;
    }


}
