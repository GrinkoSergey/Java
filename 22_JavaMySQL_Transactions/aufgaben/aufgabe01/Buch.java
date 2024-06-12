package aufgaben.aufgabe01;

import java.sql.*;
import java.util.HashMap;

/**
 * Die Klasse {@code Buch} repräsentiert ein Buch mit einer eindeutigen ID und einem Titel.
 * Sie enthält eine statische Karte zur Verwaltung aller Buchinstanzen und Methoden
 * zum Befüllen der Karte mit Daten aus einer Datenbank.
 */
public class Buch {
    public static final HashMap<Integer, Buch> buecherMap = new HashMap<>();
    private int buchID;
    private String titel;

    public Buch(int buchID, String titel) {
        this.buchID = buchID;
        this.titel = titel;
        buecherMap.put(buchID, this);
    }

    public int getBuchID() {
        return buchID;
    }

    public String getTitel() {
        return titel;
    }

    @Override
    public String toString() {
        return "Buch{" +
                "buchID=" + buchID +
                ", titel='" + titel + '\'' +
                '}';
    }

    /**
     * Befüllt die statische Karte {@code buecherMap} mit Buchdaten aus der Datenbank.
     * Liest alle Datensätze aus der Tabelle 'buch' und erstellt für jeden Datensatz ein neues Buchobjekt.
     */
    public static void buecherBefuellen() {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * from buch");

            while (rs.next()) {
                int buchID = rs.getInt(1);
                String titel = rs.getString(2);
                new Buch(buchID, titel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


