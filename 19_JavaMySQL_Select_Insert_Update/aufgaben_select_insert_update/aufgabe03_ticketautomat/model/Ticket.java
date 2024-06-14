package aufgaben_select_insert_update.aufgabe03_ticketautomat.model;

import java.util.HashMap;
/**
 * Die Ticket-Klasse repräsentiert ein Ticket mit einer ID und einer Zufallsnummer.
 */
public class Ticket {

    private int ticketID;
    private int zufNummer;

    private HashMap<Integer, Integer> tickets = new HashMap<>();

    /**
     * Konstruktor für die Ticket-Klasse.
     *
     * @param ticketID  Die ID des Tickets.
     * @param zufNummer Die Zufallsnummer des Tickets.
     */
    public Ticket(int ticketID, int zufNummer) {
        this.ticketID = ticketID;
        this.zufNummer = zufNummer;
        tickets.put(ticketID, zufNummer);
    }

    public int getTicketID() {
        return ticketID;
    }

    public int getZufNummer() {
        return zufNummer;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", zufNummer=" + zufNummer +
                ", tickets=" + tickets +
                '}';
    }
}
