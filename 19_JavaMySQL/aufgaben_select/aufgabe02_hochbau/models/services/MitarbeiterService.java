package aufgaben_select.aufgabe02_hochbau.models.services;

import aufgaben_select.aufgabe02_hochbau.MySQL;
import aufgaben_select.aufgabe02_hochbau.models.Abteilung;
import aufgaben_select.aufgabe02_hochbau.models.Mitarbeiter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MitarbeiterService {
    public static void selectMitarbeiter() {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from mitarbeiter");

            while (resultSet.next()) {
                String mitarbeiternummer = resultSet.getString("MANummer");
                boolean maschinenberechtigung = resultSet.getBoolean("Maschinenberechtigung");
                String vorname = resultSet.getString("Vorname");
                String nachname = resultSet.getString("Nachname");
                String plz = resultSet.getString("PLZ");
                Abteilung abteilung = Abteilung.abteilungMap.get(resultSet.getInt("Abteilungsnummer"));

                new Mitarbeiter(mitarbeiternummer, maschinenberechtigung, vorname, nachname, plz, abteilung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
