package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.User;
import com.example.bilabonnement.utilities.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {

    Connection connection;


    public UserRepository() {
        connection = ConnectionManager.connectToMySQL();
    }
    public User findUser(String username) {
        String query = "SELECT * FROM user WHERE user_username = '" + username + "'";
        User selectedUser = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                /*int userId = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String userPassword = resultSet.getString(3);*/
                selectedUser = new User();
            }

        } catch (SQLException e) {
            System.out.println("kunne ikke finde bruger");
            e.printStackTrace();
        }

        return selectedUser;
    }
}
