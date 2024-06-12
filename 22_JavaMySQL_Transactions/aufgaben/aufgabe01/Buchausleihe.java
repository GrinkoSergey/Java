package aufgaben.aufgabe01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Die Klasse {@code Buchausleihe} enthält Methoden zum Ausleihen und Rückgeben von Büchern.
 */
public class Buchausleihe {

    /**
     * Führt die Ausleihe eines Buches durch, indem es einen Datensatz in die Tabelle 'ausleihe' einfügt
     * und das Guthaben des Kunden entsprechend verringert.
     *
     * @param buch  Das Buch, das ausgeliehen wird.
     * @param kunde Der Kunde, der das Buch ausleiht.
     * @param dauer Die Dauer der Ausleihe in Tagen.
     * @return {@code true} wenn die Ausleihe erfolgreich war, andernfalls {@code false}.
     * @throws SQLException Wenn ein Datenbankzugriffsfehler auftritt oder die Transaktion fehlschlägt.
     */
    public static boolean buchAusleihen(Buch buch, Kunde kunde, int dauer) throws SQLException {

        if (buch == Buch.buecherMap.get(buch.getBuchID()) && kunde.getGuthaben() > dauer) {
            try (Connection connection = MySQL.getConnection()) {
                connection.setAutoCommit(false);

                try (PreparedStatement statement = connection.prepareStatement("INSERT INTO ausleihe (buchID, kundenNummer, datum, dauer) VALUES (?,?,?,?)")) {
                    Date currentDate = new Date(System.currentTimeMillis());
                    statement.setInt(1, buch.getBuchID());
                    statement.setInt(2, kunde.getKundenNummer());
                    statement.setDate(3, currentDate);
                    statement.setInt(4, dauer);

                    if (statement.executeUpdate() != 1) {
                        connection.rollback();
                        return false;
                    }

                    Ausleihe.ausleiheMap.put(buch.getBuchID(), buch);

                } catch (SQLException e) {
                    connection.rollback();
                    return false;
                }

                try (PreparedStatement statement = connection.prepareStatement("UPDATE kunde SET guthaben = guthaben - ? WHERE kundenNummer = ?")) {
                    statement.setInt(1, dauer);
                    statement.setInt(2, kunde.getKundenNummer());

                    if (statement.executeUpdate() != 1) {
                        connection.rollback();
                        return false;
                    }
                } catch (SQLException e) {
                    connection.rollback();
                    return false;
                }

                connection.commit();
                return true;
            }

        }
        return false;
    }
    /**
     * Führt die Rückgabe eines Buches durch, indem der entsprechende Datensatz aus der Tabelle 'ausleihe' gelöscht wird.
     *
     * @param buch Das Buch, das zurückgegeben wird.
     * @return {@code true} wenn die Rückgabe erfolgreich war, andernfalls {@code false}.
     */
    public static boolean rueckGabe(Buch buch) {
        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM ausleihe WHERE buchID = ?")) {
            statement.setInt(1, buch.getBuchID());

            if (statement.executeUpdate() != 1)
                return false;

            Ausleihe.ausleiheMap.remove(buch.getBuchID());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
