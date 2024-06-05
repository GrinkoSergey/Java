package aufgaben_select.aufgabe02_hochbau.models.services;

import aufgaben_select.aufgabe02_hochbau.MySQL;
import aufgaben_select.aufgabe02_hochbau.models.Abteilung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbteilungService {

    public static void selectAbteilung() {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("select * from abteilung");

            while (resultSet.next()) {
                int abteilungsnummer = resultSet.getInt("abteilungsnummer");
                String abteilungsname = resultSet.getString("abteilungsname");

                new Abteilung(abteilungsnummer, abteilungsname);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
