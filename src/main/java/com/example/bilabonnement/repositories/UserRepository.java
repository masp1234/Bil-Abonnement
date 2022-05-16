package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.User;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import javax.naming.CommunicationException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class UserRepository {

    Connection connection;


    public UserRepository() {
        connection = ConnectionManager.connectToMySQL();
    }
    public User findUser(String username) {
        connection = ConnectionManager.connectToMySQL();
        // TODO: 14/05/2022 sql injection
        String query = "SELECT * FROM user WHERE user_username = '" + username + "'";
        User selectedUser = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String userPassword = resultSet.getString(2);
                String role = resultSet.getString(3);
                selectedUser = new User(username, userPassword, role);

            }
        }
        /*catch (CommunicationException e){
            findUser(username);
        }*/
        catch (Exception e) {
            System.out.println("kunne ikke finde bruger");
            e.printStackTrace();

        }

        return selectedUser;
    }
}
