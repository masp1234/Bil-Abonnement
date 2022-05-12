package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Lease;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class LeaseRepository {

    private Connection connection;

    public LeaseRepository() {
        connection = ConnectionManager.connectToMySQL();
    }


    public void addLease(Lease lease) {
        connection = ConnectionManager.connectToMySQL();

        final String QUERY = "INSERT INTO lease" +
                "(lease_car_reg_number, lease_account_number, " +
                "lease_price, lease_period, " +
                "lease_account_reg_number, lease_customer_cpr_number"  +
                "VALUE(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, lease.getCarRegistrationNumber());
            preparedStatement.setString(2, lease.getAccountNumber());
            preparedStatement.setInt(3, lease.getPrice());
            preparedStatement.setInt(4, lease.getPeriode());
            preparedStatement.setString(5, lease.getAccountRegistrationNumber());
            preparedStatement.setInt(6, lease.getCustomerCprNumber());
            preparedStatement.executeUpdate();
            System.out.println("Customer has been added");
        } catch (SQLException e) {
            System.out.println("Could not add customer");
            e.printStackTrace();
        }

    }
}
