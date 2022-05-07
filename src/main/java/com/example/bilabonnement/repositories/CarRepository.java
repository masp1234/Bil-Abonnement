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
        List<Car> car= new ArrayList<>();
        final String QUERY="SELECT * FROM car";
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery(QUERY);
            while (resultSet.next()){
                int id= resultSet.getInt(1);
                String chassisNumber = resultSet.getString(2);
                String make = resultSet.getString(3);
                String model = resultSet.getString(4);
                String color = resultSet.getString(5);
                String registrationNumber = resultSet.getString(6);
                String equipmentLevel = resultSet.getString(7);
                double registrationFee = resultSet.getDouble(8);
                double emission = resultSet.getDouble(9);
                int leaseId = resultSet.getInt(10);
                car.add(new Car(id, chassisNumber, make, model,
                        color, registrationNumber, equipmentLevel,
                        registrationFee, emission, leaseId));
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
        final String QUERY= "INSERT INTO car" +
                "(car_id, car_chassis_number, " +
                "car_make, car_model, car_color , " +
                "car_reg_number, car_equipment_level, " +
                "car_reg_fee, car_emission, car_lease_id)" +
                " VALUE(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(QUERY);
            preparedStatement.setInt(1,car.getId());
            preparedStatement.setString(2,car.getChassisNumber());
            preparedStatement.setString(3, car.getMake());
            preparedStatement.setString(4, car.getModel());
            preparedStatement.setString(5, car.getColor());
            preparedStatement.setString(6, car.getRegistrationNumber());
            preparedStatement.setString(7, car.getEquipmentLevel());
            preparedStatement.setDouble(8, car.getRegistrationFee());
            preparedStatement.setDouble(9, car.getEmission());
            preparedStatement.setInt(10, car.getLeaseId());
            preparedStatement.executeUpdate();
            System.out.println("the car is added");
        }catch (SQLException e){
            System.out.println(" can not add");
            e.printStackTrace();
        }
    }


    public void deleteCarById(int id){
        final String QUERY="DELETE FROM car WHERE car_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println(" the car is deleted");
        }catch (SQLException e){
            System.out.println("can not delete the car");
            e.printStackTrace();
        }
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
