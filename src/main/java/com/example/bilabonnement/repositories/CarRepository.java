package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Repository
public class CarRepository {

    private Connection connection;


    CarRepository() {
        connection = ConnectionManager.connectToMySQL();
    }


    public Car getCarById(int id) {

        String query = "SELECT * FROM car WHERE car_id = " + id;

        Car car = null;


        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int carId = resultSet.getInt(1);
                String chassisNumber = resultSet.getString(2);
                String make = resultSet.getString(3);
                String model = resultSet.getString(4);
                String color = resultSet.getString(5);
                String registrationNumber = resultSet.getString(6);
                String equipmentLevel = resultSet.getString(7);
                Double registrationFee = resultSet.getDouble(8);
                Double emission = resultSet.getDouble(9);
                int leaseId = resultSet.getInt(10);

                car = new Car (carId, chassisNumber, make, model, color, registrationNumber,
                                equipmentLevel, registrationFee, emission, leaseId);


            }
        } catch (SQLException e) {
            System.out.println("kunne ikke finde car med id = " + id);
            e.printStackTrace();
        }
        return car;
    }
}
