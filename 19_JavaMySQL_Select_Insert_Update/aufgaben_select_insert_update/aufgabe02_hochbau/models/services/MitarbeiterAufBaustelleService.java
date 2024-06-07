package aufgaben_select_insert_update.aufgabe02_hochbau.models.services;


import aufgaben_select_insert_update.aufgabe02_hochbau.MySQL;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.Baustelle;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.Mitarbeiter;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.MitarbeiterAufBaustelle;

import java.math.BigDecimal;
import java.sql.*;

public class MitarbeiterAufBaustelleService {

    // --------------------- Select

    /**
     * Ruft alle Mitarbeiter-Einsätze auf Baustellen aus der Datenbank ab und erstellt entsprechende Instanzen
     */
    public static void selectMitarbeiterAufBaustelle() {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("select * from MA_auf_Baustelle");

            while (rs.next()) {
                Mitarbeiter mitarbeiter = Mitarbeiter.mitarbeiterMap.get(rs.getString("MANummer"));
                Baustelle baustelle = Baustelle.baustelleMap.get(rs.getString("Baustellennummer"));

                BigDecimal einsatzzeit = rs.getBigDecimal("Einsatzzeit");

                new MitarbeiterAufBaustelle(mitarbeiter, baustelle, einsatzzeit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --------------------- Insert, Update

    /**
     * Fügt einen Mitarbeiter-Einsatz der Datenbank hinzu und erstellt anschließend das Objekt.
     *
     * @return Die erstellte MitarbeiterAufBaustelle, oder Null, wenn es zu einem Fehler kam.
     */
    public static MitarbeiterAufBaustelle createEinsatz(Mitarbeiter mitarbeiter, Baustelle baustelle, BigDecimal einsatzzeit) {
        MitarbeiterAufBaustelle mitarbeiterAufBaustelle = null;
        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO MA_auf_Baustelle (MANummer, baustellennummer, einsatzzeit) VALUES (?, ?, ?)")) {
            statement.setString(1, mitarbeiter.getMitarbeiternummer());
            statement.setString(2, baustelle.getBaustellennummer());
            statement.setBigDecimal(3, einsatzzeit);

            if (statement.executeUpdate() > 0)
                mitarbeiterAufBaustelle = new MitarbeiterAufBaustelle(mitarbeiter, baustelle, einsatzzeit);

            return mitarbeiterAufBaustelle;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Aktualisiert eine MitarbeiterAufBaustelle in der Datenbank.
     *
     * @param mitarbeiterAufBaustelle
     * @param attribut
     * @param wert
     * @return True, wenn erfolgreich, sonst False.
     */
    public static boolean updateEinsatz(MitarbeiterAufBaustelle mitarbeiterAufBaustelle, String attribut, Object wert) {
        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE MA_auf_Baustelle SET " + attribut + " = ? " +
                             "WHERE MANummer = '" + mitarbeiterAufBaustelle.mitarbeiter.getMitarbeiternummer() + "' " +
                             "AND baustellennummer = '" + mitarbeiterAufBaustelle.baustelle.getBaustellennummer() + "'")) {
            statement.setObject(1, wert);

            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
