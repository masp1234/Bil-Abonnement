package com.example.bilabonnement.repositories;

import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;


@Repository
public class CarRepository {

    private Connection connection;


    CarRepository() {
        connection = ConnectionManager.connectToMySQL();
    }


}
