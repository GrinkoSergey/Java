package aufgaben.aufgabe01;

import java.io.FileInputStream;
import java.sql.*;

public class BenutzeraccountModel {

    /**
     * Fügt einen neuen Benutzeraccount mit einem Profilbild in die Datenbank ein.
     * @param benutzerN Der Benutzername des neuen Accounts.
     * @param bildPfad Der Dateipfad zum Profilbild, das hochgeladen werden soll.
     * @return true, wenn der Benutzeraccount erfolgreich eingefügt wurde, andernfalls false.
     */
    public static boolean insertAccountMitBild(String benutzerN, String bildPfad) {
        try (FileInputStream fileInputStream = new FileInputStream(bildPfad);
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/benutzeraccounts", "root", "");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO benutzer (benutzername, profilbild) VALUES (?,?)")) {

            statement.setString(1, benutzerN);
            statement.setBinaryStream(2, fileInputStream);

            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Fügt einen neuen Benutzeraccount ohne Profilbild in die Datenbank ein.
     * @param benutzerN Der Benutzername des neuen Accounts.
     * @return true, wenn der Benutzeraccount erfolgreich eingefügt wurde, andernfalls false.
     */
    public static boolean insertAccountOhneBild(String benutzerN) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/benutzeraccounts", "root", "");
             CallableStatement statement = connection.prepareCall("{CALL insertAccountOhneBild(?,?)}")) { // An dieser Stelle verwende ich ein CallableStatement für die Übung

            statement.setString(1, benutzerN);

            // statement.registerOutParameter(2, Types.INTEGER); // dadurch kann man AUTO_INCREMENT erhalten
            if(statement.executeUpdate() > 0) {
                System.out.println("Die neue ID: " + statement.getInt(2));
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Aktualisiert das Profilbild eines bestehenden Benutzeraccounts in der Datenbank.
     *
     * @param bildPfad Der Dateipfad zum neuen Profilbild.
     * @param benutzerNummer Die ID des Benutzeraccounts, dessen Profilbild aktualisiert werden soll.
     * @return true, wenn das Profilbild erfolgreich aktualisiert wurde, andernfalls false.
     */
    public static boolean updateBild(String bildPfad, int benutzerNummer) {
        try (FileInputStream fileInputStream = new FileInputStream(bildPfad);
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/benutzeraccounts", "root", "");
             PreparedStatement statement = connection.prepareStatement("UPDATE benutzer SET profilbild = ? WHERE id = ?")) {
            statement.setBinaryStream(1, fileInputStream);
            statement.setInt(2, benutzerNummer);

            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
