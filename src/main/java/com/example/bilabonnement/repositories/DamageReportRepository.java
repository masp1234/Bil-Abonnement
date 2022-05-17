package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Damage;
import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DamageReportRepository {

    private Connection connection;

    DamageReportRepository() {
        connection = ConnectionManager.connectToMySQL();
    }

    public void addDamageReport(DamageReport damageReport) {
        connection = ConnectionManager.connectToMySQL();

        final String QUERY = "INSERT INTO damage_report" +
                "(damage_report_date, " +
                "damage_report_description, damage_report_car_chassis_number)" +
                "VALUE(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setDate(1, (Date) damageReport.getDate());
            preparedStatement.setString(2, damageReport.getDescription());
            preparedStatement.setString(3, damageReport.getChassisNumber());


            preparedStatement.executeUpdate();
            System.out.println("DamageReport has been added");
        } catch (SQLException e) {
            System.out.println("Could not add DamageReport");
            e.printStackTrace();
        }
    }

    public List<DamageReport> getAllDamageReports() { /*mb, skal muligvis slettes*/
        connection = ConnectionManager.connectToMySQL();

        List<DamageReport> damageReports = new ArrayList<>();
        final String QUERY="SELECT * FROM damage_report";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                Date date = resultSet.getDate(1);
                String description = resultSet.getString(2);
                String chassisNumber = resultSet.getString(3);

                damageReports.add(new DamageReport(date, description, chassisNumber));
            }
            System.out.println("All damage reports are shown");
            statement.close();
        } catch (SQLException e) {
            System.out.println(e + "Could not show all damage reports");
            e.printStackTrace();
        }
        return damageReports;
    }

    public DamageReport getDamageReportByChassisNumber(String chassisNumber) {

        connection = ConnectionManager.connectToMySQL();

        String QUERY = "SELECT * FROM damage_report WHERE damage_report_car_chassis_number = '" + chassisNumber + "'";

        DamageReport damageReport = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while (resultSet.next()) {
                Date date = resultSet.getDate(1);
                String description = resultSet.getString(2);

                damageReport = new DamageReport (date, description, chassisNumber);

                System.out.println(damageReport);


            }
        } catch (SQLException e) {
            System.out.println("Could not find damageReport by chassis number: " + chassisNumber);
            e.printStackTrace();
        }
        return damageReport;
    }
}
