package com.example.bilabonnement.repositories;

import com.example.bilabonnement.utilities.ConnectionManager;

import java.sql.Connection;

public class StatisticRepository {

    Connection connection;

    public StatisticRepository() {
        this.connection = ConnectionManager.connectToMySQL();
    }

    // SELECT car_make, COUNT(Availble) as available, COUNT(reserved) as reserved, COUNT(workshop) as workshop, AVG(slutdate-startdate) as average_lease_period)
}
