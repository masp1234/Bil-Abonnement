package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CarRepository {

    private Connection connection;


    public CarRepository() {
        connection = ConnectionManager.connectToMySQL();
    }
    public List<Car> getAllCars(){

        connection = ConnectionManager.connectToMySQL();


        List<Car> car = new ArrayList<>();
        final String QUERY="SELECT * FROM car";
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery(QUERY);
            while (resultSet.next()){
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


                car.add(new Car(registrationNumber, chassisNumber, make, model,
                        color, equipmentLevel,
                        registrationFee, emission, status, url));
            }
            System.out.println("can show all cars");

            statement.close();

        }
        catch (SQLException e){
            System.out.println(e + "can not show all cars");
            e.printStackTrace();
        }
        return car;
    }

    public void addCar(Car car){

        connection = ConnectionManager.connectToMySQL();

        final String QUERY= "INSERT INTO car" +
                "(car_reg_number, car_chassis_number, " +
                "car_make, car_model, car_color , " +
                "car_equipment_level, car_reg_fee, " +
                "car_emission, car_status, car_url)" +
                " VALUE(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(QUERY);
            preparedStatement.setString(1,car.getRegistrationNumber());
            preparedStatement.setString(2,car.getChassisNumber());
            preparedStatement.setString(3, car.getMake());
            preparedStatement.setString(4, car.getModel());
            preparedStatement.setString(5, car.getColor());
            preparedStatement.setString(6, car.getEquipmentLevel());
            preparedStatement.setDouble(7, car.getRegistrationFee());
            preparedStatement.setDouble(8, car.getEmission());
            preparedStatement.setString(9, "available");
            preparedStatement.setString(10, car.getUrl());
            preparedStatement.executeUpdate();
            System.out.println("the car is added");
        }catch (SQLException e){
            System.out.println(" can not add");
            e.printStackTrace();
        }
    }


    public void deleteCarById(String id){
        connection = ConnectionManager.connectToMySQL();

        final String QUERY="DELETE FROM car WHERE car_reg_number = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            System.out.println(" the car is deleted");
        }catch (SQLException e){
            System.out.println("can not delete the car");
            e.printStackTrace();
        }
    }


    public Car getCarById(String id) {

        connection = ConnectionManager.connectToMySQL();

        String query = "SELECT * FROM car WHERE car_reg_number = '" + id + "'";

        Car car = null;

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
                Double registrationFee = resultSet.getDouble(7);
                Double emission = resultSet.getDouble(8);
                String status = resultSet.getString(9);
                String url = resultSet.getString(10);

                car = new Car (registrationNumber, chassisNumber, make, model, color,
                                equipmentLevel, registrationFee, emission, status, url);

                System.out.println(car);


            }
        } catch (SQLException e) {
            System.out.println("kunne ikke finde car med id = " + id);
            e.printStackTrace();
        }
        return car;
    }

    public void updateCar(Car car) {

        connection = ConnectionManager.connectToMySQL();

        String query = "UPDATE car SET car_chassis_number = ?, car_make = ?, car_model = ?, car_color = ?, " +
                "car_equipment_level = ?, car_reg_fee = ?, car_emission = ?, is_rented = ?, is_ready_to_rent = ?" +
                "WHERE car_reg_number = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getChassisNumber());
            preparedStatement.setString(2, car.getMake());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setString(5, car.getEquipmentLevel());
            preparedStatement.setDouble(6, car.getRegistrationFee());
            preparedStatement.setDouble(7, car.getEmission());
            preparedStatement.setString(8, car.getRegistrationNumber());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("kunne ikke opdatere car med car_id  = " + car.getRegistrationNumber());
            e.printStackTrace();
        }


    }
}
