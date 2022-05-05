package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;


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

                System.out.println(car);


            }
        } catch (SQLException e) {
            System.out.println("kunne ikke finde car med id = " + id);
            e.printStackTrace();
        }
        return car;
    }

    public void updateCar(Car car) {

        String query = "UPDATE car SET car_chassis_number = ?, car_make = ?, car_model = ?, car_color = ?, " +
                "car_reg_number = ?, car_equipment_level = ?, car_reg_fee = ?, car_emission = ?, car_lease_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getChassisNumber());
            preparedStatement.setString(2, car.getMake());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setString(5, car.getRegistrationNumber());
            preparedStatement.setString(6, car.getEquipmentLevel());
            preparedStatement.setDouble(7, car.getRegistrationFee());
            preparedStatement.setDouble(8, car.getEmission());
            preparedStatement.setInt(9, car.getLeaseId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("kunne ikke opdatere car med car_id  = " + car.getId());
            e.printStackTrace();
        }


    }
}
