package aufgaben_select_insert_update.aufgabe02_hochbau.models.services;

import aufgaben_select_insert_update.aufgabe02_hochbau.MySQL;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.Abteilung;

import java.sql.*;

public class AbteilungService {
    // ---------------------------- Select

    /**
     * Ruft alle Abteilungen aus der Datenbank ab und erstellt Instanzen
     */
    public static void selectAbteilung() {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement()) {
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

    // --------------------- Insert, Update

    /**
     * Fügt eine Abteilung der Datenbank hinzu und erstellt anschließend das Objekt.
     *
     * @return Die erstellte Abteilung, oder Null, wenn es zu einem Fehler kam.
     */
    public static Abteilung createAbteilung(String abteilungsName) {
        Abteilung abteilung = null;

        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO abteilung (abteilungsName) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, abteilungsName);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                int abteilungsnummer = resultSet.getInt(1);
                abteilung = new Abteilung(abteilungsnummer, abteilungsName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abteilung;
    }

    /**
     * Aktualisiert eine Abteilung in der Datenbank.
     *
     * @param abteilung
     * @param attribut
     * @param wert
     * @return True, wenn erfolgreich, sonst False.
     */
    public static boolean updateAbteilung(Abteilung abteilung, String attribut, Object wert) {
        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE abteilung SET " + attribut + " = ? WHERE abteilungsnummer = " + abteilung.getAbteilungsnummer()
             )) {
            statement.setObject(1, wert);
            int anzahl = statement.executeUpdate();
            return anzahl == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
