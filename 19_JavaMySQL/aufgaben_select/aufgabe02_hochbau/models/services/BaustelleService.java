package aufgaben_select.aufgabe02_hochbau.models.services;

import aufgaben_select.aufgabe02_hochbau.MySQL;
import aufgaben_select.aufgabe02_hochbau.models.Baustelle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaustelleService {
    public static void selectBaustelle() {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from baustelle");

            while (resultSet.next()) {
                String baustellennummer = resultSet.getString("baustellennummer");
                String bezeichnung = resultSet.getString("bezeichnung");

                new Baustelle(baustellennummer, bezeichnung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
