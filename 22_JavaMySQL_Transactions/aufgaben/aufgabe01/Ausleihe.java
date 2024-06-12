package aufgaben.aufgabe01;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;
/**
 * Die Klasse {@code Ausleihe} repräsentiert eine Ausleihe eines Buches durch einen Kunden.
 * Sie enthält eine statische Karte zur Verwaltung aller Ausleihvorgänge sowie Methoden
 * zum Abrufen von Informationen über Ausleihen und zum Befüllen der Karte mit Daten aus einer Datenbank.
 */
public class Ausleihe {
    public static HashMap<Integer, Buch> ausleiheMap = new HashMap<>();

    private int id;
    private Buch buch;
    private Kunde kunde;
    private Date datum;
    private int dauer;

    public Ausleihe(int id, Buch buch, Kunde kunde, int dauer) {
        this.id = id;
        this.buch = buch;
        this.kunde = kunde;
        this.dauer = dauer;

        ausleiheMap.put(buch.getBuchID(), buch);
    }

    public int getId() {
        return id;
    }

    public Buch getBuch() {
        return buch;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getDauer() {
        return dauer;
    }

    @Override
    public String toString() {
        return "Ausleihe{" +
                "id=" + id +
                ", buch=" + buch.getTitel() +
                ", kunde=" + kunde.getKundenNummer() +
                ", datum=" + datum +
                ", dauer=" + dauer +
                '}';
    }
    /**
     * Befüllt die statische Karte {@code ausleiheMap} mit Ausleihedaten aus der Datenbank.
     * Liest alle Datensätze aus der Tabelle 'ausleihe' und erstellt für jeden Datensatz ein neues Ausleihe-Objekt.
     */
    public static void befuelleAusleihe() {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * from ausleihe");

            while (rs.next()) {
                int id = rs.getInt(1);
                Buch buch = Buch.buecherMap.get(rs.getInt(2));
                Kunde kunde = Kunde.kundenMap.get(rs.getInt(3));
                int dauer = rs.getInt(5);
                new Ausleihe(id, buch, kunde, dauer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
