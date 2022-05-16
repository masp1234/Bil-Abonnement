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
                "lease_price, lease_period, " +
                " lease_customer_cpr_number," +
                "lease_account_number," +
                "lease_reg_number)"  +
                "VALUE(?,?,?,?,?,?)";
        System.out.println(lease);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, lease.getCarRegistrationNumber());
            preparedStatement.setInt(2, lease.getPrice());
            preparedStatement.setInt(3, lease.getPeriod());
            preparedStatement.setString(4, lease.getCustomerCprNumber());
            preparedStatement.setString(5, lease.getCustomerAccountNumber());
            preparedStatement.setString(6, lease.getCustomerRegNumber());
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
                int period = resultSet.getInt(3);
                String cpr = resultSet.getString(4);
                String accountNumber = resultSet.getString(5);
                String regNumber = resultSet.getString(6);
                lease = new Lease(price,period,reg,cpr,accountNumber,regNumber);

            }
        }

        catch (Exception e) {
            System.out.println("kunne ikke finde lease");
            e.printStackTrace();

        }

        return lease;
    }
}
