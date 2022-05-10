package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class CustomerRepository {

    private Connection connection;

    CustomerRepository() {
        connection = ConnectionManager.connectToMySQL();
    }

    public void addCustomer(Customer customer) {
        final String QUERY = "INSERT INTO customer" +
                "(customer_cpr, customer_accountNumber, )" +
                "customer_registrationNumber, customer_firstName, customer_lastName, " +
                "customer_email, customer_phoneNumber, customer_address, " +
                "customer_zipCode, customer_city)" +
                "VALUE(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, customer.getCpr());
            preparedStatement.setInt(2, customer.getAccountNumber());
            preparedStatement.setInt(3, customer.getRegistrationNumber());
            preparedStatement.setString(4, customer.getFirstname());
            preparedStatement.setString(5, customer.getLastName());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setInt(7, customer.getPhoneNumber());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getZipCode());
            preparedStatement.setString(10, customer.getCity());
            preparedStatement.executeUpdate();
            System.out.println("Customer has been added");
        } catch (SQLException e) {
            System.out.println("Could not add customer");
            e.printStackTrace();
        }
    }

}
