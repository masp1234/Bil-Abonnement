package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.models.User;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class CustomerRepository {

    private Connection connection;

    CustomerRepository() {
        connection = ConnectionManager.connectToMySQL();
    }


    //efter normaliseringsregel 3, skal zipcode splittes op i et ektra table
    /*Danny
    * Daniel*/
    public void addCustomer(Customer customer) {

        final String QUERY = "INSERT INTO customer" +
                "(customer_cpr_number, customer_firstname, customer_lastname, " +
                "customer_email, customer_phone, customer_address, " +
                "customer_zipcode)" +
                "VALUE(?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, customer.getCpr());
            preparedStatement.setString(2, customer.getFirstname());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getAddress());
            preparedStatement.setString(7, customer.getZipCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not add customer");
            e.printStackTrace();
        }
    }

    /*Daniel
    * Danny*/
    public Customer findCustomerByCPR(String cprNumber) {

        String query = "SELECT customer_cpr_number, customer_firstname, customer_lastname, customer_email, customer_phone, customer_zipcode, customer_address, zipcode.city FROM customer INNER JOIN zipcode ON customer.customer_zipcode = zipcode.zipcode WHERE customer_cpr_number = '" + cprNumber + "'";
        Customer selectedCustomer = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                String cpr = resultSet.getString(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String email = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String zipcode = resultSet.getString(6);
                String address = resultSet.getString(7);
                String city = resultSet.getString(8);

                selectedCustomer = new Customer(cpr,firstName,lastName,email,phone,address,zipcode,city);
            }
        } catch (Exception e) {
            System.out.println("kunne ikke finde bruger");
            e.printStackTrace();
        }
        return selectedCustomer;
    }
}
