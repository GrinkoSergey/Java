package aufgaben.aufgabe02;

import java.sql.*;

public class Service {

    // Erstellen Sie zur Aufgabe Universität ein Java Programm
    // Die View der Kursbelegung soll KursKürzel, KursName, StudentNummer, StudentVorname, StudentNachname, Semester und Note beinhalten.

    /**
     * Führt die View "kursbelegungView" aus und gibt das Ergebnis als String zurück
     * @return Das Ergebnis der View-Abfrage als String.
     */
    public static String kursbelegungView() {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("Select * from kursbelegungView");

            StringBuilder sb = new StringBuilder();

            // Überschriften der Spalten hinzufügen
            sb.append(" | ");
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                sb.append(resultSet.getMetaData().getColumnName(i)).append(" | ");
            }

            // Datenzeilen hinzufügen
            while (resultSet.next()) {
                sb.append("\n");
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++)
                    sb.append(resultSet.getString(i)).append(" | ");
            }
            return sb.toString();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return "";
        }
    }

    // Eine Prozedur soll neue Kursbelegungen anlegen und eine andere Prozedur soll die Note der Kursbelegung ändern können.

    /**
     * Führt die Prozedur "insertKursbelegung" aus.
     * @param stdNum die Studentennummer
     * @param kk das Kurskürzel
     * @param sem das Semester
     * @param n die Note
     * @return 'true' bei erfolgreicher Ausführung, andernfalls 'false'
     */
    public static boolean insertKursbelegung(int stdNum, String kk, String sem, double n) {
        try (Connection connection = MySQL.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL insertKursbelegung (?,?,?,?)}")) {

            statement.setInt(1, stdNum);
            statement.setString(2, kk);
            statement.setString(3, sem);
            statement.setDouble(4, n);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Führt die Prozedur "updateKursbelegung" aus.
     * @param stdNum die Studentennummer
     * @param kk das Kurskürzel
     * @param n die neue Note
     * @return 'true' bei erfolgreicher Ausführung, andernfalls 'false'
     */
    public static boolean updateKursbelegung (int stdNum, String kk, double n) { // stdNum - StudentNummer, kk - KursKürzel, n - Note
        try (Connection connection = MySQL.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL updateKursbelegung(?,?,?)}")) {
            statement.setInt(1, stdNum);
            statement.setString(2, kk);
            statement.setDouble(3, n);


            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
