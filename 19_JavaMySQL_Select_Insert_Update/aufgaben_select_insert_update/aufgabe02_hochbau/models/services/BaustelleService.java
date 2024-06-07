package aufgaben_select_insert_update.aufgabe02_hochbau.models.services;

import aufgaben_select_insert_update.aufgabe02_hochbau.MySQL;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.Baustelle;

import java.sql.*;

public class BaustelleService {
    // ------------------------ Select

    /**
     * Ruft alle Baustellen aus der Datenbank ab und erstellt Instanzen
     */
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

    // --------------------- Insert, Update

    /**
     * Fügt eine Baustelle der Datenbank hinzu und erstellt anschließend das Objekt.
     *
     * @return Die erstellte Baustelle, oder Null, wenn es zu einem Fehler kam.
     */
    public static Baustelle createBaustelle(String baustellennummer, String bezeichnung) {
        Baustelle baustelle = null;
        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO baustelle (baustellennummer, bezeichnung) VALUES (?,?)")) {

            statement.setString(1, baustellennummer);
            statement.setString(2, bezeichnung);
            statement.executeUpdate();

            if (statement.executeUpdate() > 0)
                baustelle = new Baustelle(baustellennummer, bezeichnung);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return baustelle;
    }

    /**
     * Aktualisiert eine Baustelle in der Datenbank.
     *
     * @param baustelle
     * @param attribut
     * @param wert
     * @return True, wenn erfolgreich, sonst False.
     */
    public static boolean updateBaustelle(Baustelle baustelle, String attribut, Object wert) {

        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE baustelle SET " + attribut + " = ? WHERE baustellennummer = " + baustelle.getBaustellennummer())) {
            statement.setObject(1, wert);
            int anzahl = statement.executeUpdate();
            return anzahl == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
