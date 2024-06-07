package aufgaben_select_insert_update.aufgabe02_hochbau.models.services;

import aufgaben_select_insert_update.aufgabe02_hochbau.MySQL;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.Abteilung;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.Mitarbeiter;

import java.sql.*;

public class MitarbeiterService {

    // --------------------- Select

    /**
     * Ruft alle Mitarbeiter aus der Datenbank ab und erstellt Instanzen
     */
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

    // --------------------- Insert, Update

    /**
     * Fügt einen Mitarbeiter der Datenbank hinzu und erstellt anschließend das Objekt.
     *
     * @return Den erstellten Mitarbeiter, oder Null, wenn es zu einem Fehler kam.
     */
    public static Mitarbeiter createMitarbeiter(String manummer, boolean maschinenberechtigung, String vorname, String nachname, String plz, Abteilung abteilung) {
        Mitarbeiter mitarbeiter = null;
        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO mitarbeiter (manummer, maschinenberechtigung, vorname, nachname, plz, abteilungsnummer) VALUES (?,?,?,?,?,?)")) {

            statement.setString(1, manummer);
            statement.setBoolean(2, maschinenberechtigung);
            statement.setString(3, vorname);
            statement.setString(4, nachname);
            statement.setString(5, plz);
            statement.setInt(6, abteilung.getAbteilungsnummer());

            statement.executeUpdate();
            ResultSet rs = statement.getResultSet();

            if (statement.executeUpdate() > 0)
                mitarbeiter = new Mitarbeiter(manummer, maschinenberechtigung, vorname, nachname, plz, abteilung);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mitarbeiter;
    }

    /**
     * Aktualisiert einen Mitarbeiter in der Datenbank.
     *
     * @param mitarbeiter
     * @param attribut
     * @param wert
     * @return True, wenn erfolgreich, sonst False.
     */
    public static boolean updateMitarbeiter(Mitarbeiter mitarbeiter, String attribut, Object wert) {
        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE mitarbeiter SET " + attribut + " = ? WHERE manummer = " + mitarbeiter.getMitarbeiternummer())) {
            statement.setObject(1, wert);
            int anzahl = statement.executeUpdate();
            return anzahl == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
