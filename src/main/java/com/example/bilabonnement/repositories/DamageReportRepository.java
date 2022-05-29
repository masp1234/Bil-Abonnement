package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DamageReportRepository {

    private Connection connection;

    public DamageReportRepository() {
        connection = ConnectionManager.connectToMySQL();
    }


    /*Danny*/
    public void addDamageReport(DamageReport damageReport) {
        connection = ConnectionManager.connectToMySQL();

        final String QUERY = "INSERT INTO damage_report" +
                "(damage_report_date, " +
                "damage_report_description, damage_report_car_chassis_number)" +
                "VALUE(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, damageReport.getDate());
            preparedStatement.setString(2, damageReport.getDescription());
            preparedStatement.setString(3, damageReport.getChassisNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not add DamageReport");
            e.printStackTrace();
        }
    }

    /*Danny
    * Daniel*/
    public List<DamageReport> getAllDamageReports(String chassisNumber) {
        connection = ConnectionManager.connectToMySQL();
        List<DamageReport> damageReports = new ArrayList<>();
        final String QUERY = "SELECT * FROM damage_report WHERE damage_report_car_chassis_number = '" + chassisNumber + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String date = resultSet.getString(2);
                String description = resultSet.getString(3);

                damageReports.add(new DamageReport(id,date, description, chassisNumber,0));
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e + "Could not show all damage reports");
            e.printStackTrace();
        }
        return damageReports;
    }

    /*Danny
    * Daniel*/
    public DamageReport getDamageReportById(int id) {

        connection = ConnectionManager.connectToMySQL();

        String QUERY = "SELECT * FROM damage_report WHERE damage_report_id = '" + id + "'";

        DamageReport damageReport = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            while (resultSet.next()) {
                String date = resultSet.getString(2);
                String description = resultSet.getString(3);
                String chassisNumber = resultSet.getString(4);
                damageReport = new DamageReport();
                damageReport.setChassisNumber(chassisNumber);
                damageReport.setDate(date);
                damageReport.setDescription(description);
            }
        } catch (SQLException e) {
            System.out.println("Could not find damageReport by id: " + id);
            e.printStackTrace();
        }
        return damageReport;
    }

    /*Martin*/
    public void deleteAllDamageReportsByChassisNumber(String chassisNumber) {
        String query = "DELETE FROM damage_report WHERE damage_report_car_chassis_number = '" + chassisNumber + "'";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("kunne ikke slette alle damage reports med car chassisNumber: " + chassisNumber);
            e.printStackTrace();
        }
    }
}
