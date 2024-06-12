package aufgaben.aufgabe01;

import java.sql.*;
import java.util.HashMap;

/**
 * Die Klasse {@code Kunde} repräsentiert einen Kunden mit einer eindeutigen Kundennummer,
 * einem Nachnamen und einem Guthaben. Sie enthält eine statische Karte zur Verwaltung
 * aller Kundeninstanzen und Methoden zum Befüllen der Karte mit Daten aus einer Datenbank.
 */
public class Kunde {
    public static HashMap<Integer, Kunde> kundenMap = new HashMap<>();
    private int kundenNummer;
    private String nachname;
    private int guthaben;

    public Kunde(int kundenNummer, String nachname, int guthaben) {
        this.kundenNummer = kundenNummer;
        this.nachname = nachname;
        this.guthaben = guthaben;
        kundenMap.put(kundenNummer, this);
    }

    public int getKundenNummer() {
        return kundenNummer;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public double getGuthaben() {
        return guthaben;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "kundenNummer=" + kundenNummer +
                ", nachname='" + nachname + '\'' +
                ", guthaben=" + guthaben +
                '}';
    }

    /**
     * Befüllt die statische Karte {@code kundenMap} mit Kundendaten aus der Datenbank.
     * Liest alle Datensätze aus der Tabelle 'kunde' und erstellt für jeden Datensatz ein neues Kundenobjekt.
     */
    public static void befuelleKunden() {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * from kunde");

            while (rs.next()) {
                int kundenNummer = rs.getInt(1);
                String nachname = rs.getString(2);
                int guthaben = rs.getInt(3);
                new Kunde(kundenNummer, nachname, guthaben);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
