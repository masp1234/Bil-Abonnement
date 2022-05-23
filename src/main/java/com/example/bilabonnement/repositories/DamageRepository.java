package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Damage;
import com.example.bilabonnement.utilities.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DamageRepository {
    private Connection connection;

    public DamageRepository() {
        connection = ConnectionManager.connectToMySQL();
    }

    public List<Damage> getAllDamages(int id){
        List<Damage> damages= new ArrayList<>();
        final String QUERY="SELECT * FROM damage where damage_report_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               int damageId = resultSet.getInt(1);
               String description = resultSet.getString(2);
               int price = resultSet.getInt(3);
                damages.add(new Damage(damageId, description,price));
            }
        }catch (SQLException e){
            System.out.println(e + " damage not found");
            e.printStackTrace();
        }
        return damages;
    }


    public void addDamage(Damage damage){
        final String QUERY = "INSERT INTO damage(damage_description," +
                " damage_price, damage_report_id) VALUE(?, ?, ?)";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(QUERY);
            preparedStatement.setString(1, damage.getDescription());
            preparedStatement.setInt(2,damage.getPrice());
            preparedStatement.setInt(3, damage.getDamageReportId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e + " can not add damage");
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        final String QUERY = "DELETE FROM damage WHERE damage_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("is not deleted");
            e.printStackTrace();
        }
    }

}
