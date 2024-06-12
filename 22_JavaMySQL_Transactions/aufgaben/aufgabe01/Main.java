package aufgaben.aufgabe01;

import java.sql.SQLException;

/*
    Bücherverleihen
    Bücher werden gespeichert mit ID und Titel. Jedes Buch ist nur ein Mal im Bestand.
    Kunden haben Nummer, Name und Guthaben.
    Ausleihe ist gespeichert mit Buch, Kunde, Datum, Dauer.
    Wird ein Buch ausgeliehen, wird es in Ausleihe eingetragen und für die Dauer in Tagen je 1€ vom Guthaben des Kunden abgezogen.
    Wird das Buch zurückgebracht, wird es aus der Ausleihe gelöscht.

    Um ein Buch ausleihen zu können, muss geprüft werden, ob das Buch bereits ausgeliehen ist.
    Dann muss geprüft werden, ob Kunde genug Guthaben für die Dauer hat.
    Ist beides Okay, kann das Buch ausgeliehen werden.

    Dieser Vorgang soll innerhalb einer Transaktion stattfinden. Tritt ein Fehler auf, wird der Vorgang rückgängig gemacht.

*/
public class Main {
    public static void main(String[] args) {

        // Fülle die Karte der Bücher mit Daten aus der Datenbank.
        Buch.buecherBefuellen();
        System.out.println(Buch.buecherMap);

        System.out.println();

        // Lade Kundeninformationen aus der Datenbank und fülle die Kundenkarte.
        Kunde.befuelleKunden();
        System.out.println(Kunde.kundenMap);

        System.out.println();

        // Lade Ausleihdaten aus der Datenbank und fülle die Ausleihekarte.
        Ausleihe.befuelleAusleihe();
        System.out.println(Ausleihe.ausleiheMap);

        try {
            // Führe eine Buchausleihe für das Buch mit ID 1 durch, von Kunde mit ID 1, für 1 Tag.
            Buchausleihe.buchAusleihen(Buch.buecherMap.get(1), Kunde.kundenMap.get(1), 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();

        // Gib die aktualisierte Ausleihekarte aus.
        System.out.println(Ausleihe.ausleiheMap);

        // Führe eine Rückgabe für das Buch mit ID 1 durch.
        Buchausleihe.rueckGabe(Buch.buecherMap.get(1));

        System.out.println();

        // Gib die aktualisierte Ausleihekarte aus, um zu zeigen, dass das Buch zurückgegeben wurde.
        System.out.println(Ausleihe.ausleiheMap);

    }
}
