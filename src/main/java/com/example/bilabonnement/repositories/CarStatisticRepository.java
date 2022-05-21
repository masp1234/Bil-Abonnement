package com.example.bilabonnement.repositories;
import com.example.bilabonnement.models.CarMakeStatistic;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarStatisticRepository {

    Connection connection;

    public CarStatisticRepository() {
        this.connection = ConnectionManager.connectToMySQL();
    }




    public List<CarMakeStatistic> getCarMakes() {

        List<CarMakeStatistic> carMakeStatistics = new ArrayList<>();

        String query = "SELECT DISTINCT car_make from car ORDER BY car_make ASC";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String carMake = resultSet.getString(1);

            CarMakeStatistic carMakeStatistic = new CarMakeStatistic();
            carMakeStatistic.setCarMake(carMake);
            carMakeStatistics.add(carMakeStatistic);


        } catch (SQLException e) {
            System.out.println("Kunne ikke finde car_makes i car table");
            e.printStackTrace();
        }

        return carMakeStatistics;

    }
    public ArrayList<ArrayList<Integer>> getCarMakesAndStatus() {

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
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int counter = 0;
            while(resultSet.next()) {
                int avilableCars = resultSet.getInt(2);
                int reservedCars = resultSet.getInt(3);
                int workshopCars = resultSet.getInt(4);
                list.add(new ArrayList<Integer>());
                list.get(counter).add(avilableCars);
                list.get(counter).add(reservedCars);
                list.get(counter).add(workshopCars);
                counter++;
            }
        } catch (SQLException e) {
            System.out.println("Kunne ikke kalde getCarMakesAndStatus");
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }


        return list;
    }

    public List<Double> getAverageLeasePeriodsPerCarMake() {
        List<Double> averageLeasePeriodsPerCarMake = new ArrayList<>();

        String query = "SELECT car_make, AVG(DATEDIFF(lease_end_date, lease_start_date)) as average_date_diff \n" +
                "FROM car \n" +
                "JOIN lease on car_reg_number = lease_car_reg_number\n" +
                "GROUP BY car_make\n" +
                "ORDER BY car_make\n";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            double averageLeasePeriod = resultSet.getDouble(2);
            averageLeasePeriodsPerCarMake.add(averageLeasePeriod);

        } catch (SQLException e) {
            System.out.println("Kunne ikke finde gennemsnitlige lease perioder per bilmærke");
            e.printStackTrace();
        }

        return averageLeasePeriodsPerCarMake;
    }

    public List<Double> getAverageLeasePricePerMonthPerCarMake() {
        List<Double> averageLeasePricePerMonthPerCarMake = new ArrayList<>();

        String query = "SELECT car_make, AVG(lease_price) as price_per_month \n" +
                "FROM car \n" +
                "JOIN lease \n" +
                "ON car_reg_number = lease_car_reg_number\n" +
                "GROUP BY car_make\n" +
                "ORDER BY car_make\n";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            double averagePricePerMonth = resultSet.getDouble(2);
            averageLeasePricePerMonthPerCarMake.add(averagePricePerMonth);

        } catch (SQLException e) {
            System.out.println("Kunne ikke finde gennesnitlige leasingpris per måned per bilmærke");
            e.printStackTrace();
        }

        return averageLeasePricePerMonthPerCarMake;
    }


    //public List<Integer> getAverageDamagesPerDamageReportPerCarMake

}
