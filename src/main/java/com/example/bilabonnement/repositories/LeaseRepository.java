package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Lease;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class LeaseRepository {

    private Connection connection;

    public LeaseRepository() {
        connection = ConnectionManager.connectToMySQL();
    }


    public boolean addLease(Lease lease) {
        connection = ConnectionManager.connectToMySQL();

        final String QUERY = "INSERT INTO lease" +
                "(lease_car_reg_number, " +
                "lease_price, lease_start_date, lease_end_date, " +
                " lease_customer_cpr_number," +
                "lease_account_number," +
                "lease_reg_number)"  +
                "VALUE(?,?,?,?,?,?,?)";
        System.out.println(lease);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, lease.getCarRegistrationNumber());
            preparedStatement.setInt(2, lease.getPricePerMonth());
            preparedStatement.setString(3,lease.getStartDate());
            preparedStatement.setString(4, lease.getEndDate());
            preparedStatement.setString(5, lease.getCustomerCprNumber());
            preparedStatement.setString(6, lease.getCustomerAccountNumber());
            preparedStatement.setString(7, lease.getCustomerRegNumber());
            preparedStatement.executeUpdate();
            System.out.println("Customer has been added");
            return true;
        } catch (SQLException e) {
            System.out.println("Could not add customer");
            e.printStackTrace();
            return false;
        }

    }
    public Lease findlease(String reg) {
        connection = ConnectionManager.connectToMySQL();
        // TODO: 14/05/2022 sql injection
        String query = "SELECT * FROM lease WHERE lease_car_reg_number = '" + reg + "'";

        Lease lease = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int price = resultSet.getInt(2);
                String cpr = resultSet.getString(3);
                String accountNumber = resultSet.getString(4);
                String regNumber = resultSet.getString(5);
                String startDate = resultSet.getString(6);
                String endDate = resultSet.getString(7);
                lease = new Lease(price,startDate,endDate,reg,cpr,accountNumber,regNumber);

            }
        }

        catch (Exception e) {
            System.out.println("kunne ikke finde lease");
            e.printStackTrace();

        }

        return lease;
    }

    public void  updateLease(Lease lease) {
        String query = "UPDATE lease SET lease_price = ?, lease_start_date = ?, lease_end_date = ?," +
                " lease_customer_cpr_number = ?, lease_account_number = ?," +
                " lease_reg_number = ? " +
                "WHERE lease_car_reg_number = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, lease.getPricePerMonth());
            preparedStatement.setString(2, lease.getStartDate());
            preparedStatement.setString(3, lease.getEndDate());
            preparedStatement.setString(4, lease.getCustomerCprNumber());
            preparedStatement.setString(5, lease.getCustomerAccountNumber());
            preparedStatement.setString(6, lease.getCustomerRegNumber());
            preparedStatement.setString(7, lease.getCarRegistrationNumber());

            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            System.out.println("kunne ikke opdatere lease med bil registrationnummer = " + lease.getCarRegistrationNumber());
            e.printStackTrace();
        }
    }

    public void deleteBy(String reg) {
        final String QUERY = "DELETE FROM lease WHERE lease_car_reg_number=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, reg);
            preparedStatement.executeUpdate();
            System.out.println("Is deleted");

        } catch (SQLException e) {
            System.out.println("is not deleted");
            e.printStackTrace();
        }
    }


}
