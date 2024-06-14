package aufgabe01_benutzerverwaltung.model;

import aufgabe01_benutzerverwaltung.MySQL;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Die Klasse Benutzer repräsentiert einen Benutzer im System.
 */
public class Benutzer {

    private String benutzername;
    private String vorname;
    private String nachname;

    public static HashMap<String, Benutzer> benutzerHashMap = new HashMap<>();

    /**
     * Konstruktor zur Erstellung eines neuen Benutzers.
     *
     * @param benutzername Der Benutzername des Benutzers.
     * @param vorname      Der Vorname des Benutzers.
     * @param nachname     Der Nachname des Benutzers.
     */
    public Benutzer(String benutzername, String vorname, String nachname) {
        this.benutzername = benutzername;
        this.vorname = vorname;
        this.nachname = nachname;

        benutzerHashMap.put(benutzername, this);
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return "BenutzerModel{" +
                "benutzername='" + benutzername + '\'' +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                '}';
    }

    // Methode zum Verschlüsseln des Passwortes
    private static byte[] encode(String passwort) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        return digest.digest(passwort.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Füllt die HashMap mit Daten aus der Tabelle benutzerverwaltung in der Datenbank.
     */
    public static void selectAll() {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM benutzer");
            while (rs.next()) {
                String benutzername = rs.getString("name");
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");

                // Erstelle ein neues Benutzer-Objekt und füge es der HashMap hinzu
                new Benutzer(benutzername, vorname, nachname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Registriert einen neuen Benutzer im System.
     *
     * @param benutzername Der Benutzername des neuen Benutzers.
     * @param passwort     Das Passwort des neuen Benutzers.
     * @param vorname      Der Vorname des neuen Benutzers.
     * @param nachname     Der Nachname des neuen Benutzers.
     * @return true, wenn die Registrierung erfolgreich war, false sonst.
     */
    public static boolean register(String benutzername, String passwort, String vorname, String nachname) {
        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO benutzer (name, passwort, vorname, nachname) VALUES (?,?,?,?)")) {

            byte[] bytePasswort = encode(passwort);
            statement.setString(1, benutzername);
            statement.setBytes(2, bytePasswort);
            statement.setString(3, vorname);
            statement.setString(4, nachname);

            if (statement.executeUpdate() > 0) {
                new Benutzer(benutzername, vorname, nachname);
                return true;
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Loggt einen Benutzer im System ein.
     *
     * @param benutzername Der Benutzername des Benutzers.
     * @param passwort     Das Passwort des Benutzers.
     * @return Das Benutzerobjekt, wenn die Anmeldung erfolgreich war, null sonst.
     */
    public static Benutzer login(String benutzername, String passwort) {
        Benutzer benutzer = null;
        byte[] bytePasswortEingabe = null;
        byte[] bytePasswortDB = null;

        try {
            bytePasswortEingabe = encode(passwort);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT passwort FROM benutzer WHERE name = ?")) {
            statement.setString(1, benutzername);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                bytePasswortDB = rs.getBytes("passwort");
            }

            // Vergleiche die eingegebenen und gespeicherten Passwörter
            if (bytePasswortEingabe != null) {
                if (Arrays.equals(bytePasswortEingabe, bytePasswortDB)) {
                    benutzer = benutzerHashMap.get(benutzername);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return benutzer;
        }

        // Fehlermeldung, wenn die Anmeldung fehlgeschlagen ist
        if (benutzer == null) {
            System.out.println("Fehlermeldung!\nFalscher Benutzername oder falsches Passwort!\nAUFPASSEN!");
        }
        return benutzer;
    }


}

