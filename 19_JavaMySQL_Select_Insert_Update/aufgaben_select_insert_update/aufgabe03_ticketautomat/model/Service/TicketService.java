package aufgaben_select_insert_update.aufgabe03_ticketautomat.model.Service;

import aufgaben_select_insert_update.aufgabe03_ticketautomat.MySQL;
import aufgaben_select_insert_update.aufgabe03_ticketautomat.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * Die TicketService-Klasse bietet Methoden zum Erstellen und Überprüfen von Tickets.
 */
public class TicketService {

    /**
     * Erstellt ein neues Ticket mit einer zufälligen Nummer und speichert es in der Datenbank.
     *
     * @return Das erstellte Ticket.
     */
    public static Ticket createTicket() {
        Random rand = new Random();
        int zufNummer = rand.nextInt(9000) + 1000;

        try (Connection connection = MySQL.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO ticket (zufNummer) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, zufNummer);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            rs.next();
            int ticketID = rs.getInt(1);
            return new Ticket(ticketID, zufNummer);


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Überprüft den Login eines Benutzers anhand der TicketID und der Zufallsnummer.
     *
     * @param ticketID   Die ID des Tickets.
     * @param meineNummer Die vom Benutzer eingegebene Zufallsnummer.
     * @return true, wenn die Login-Daten korrekt sind, sonst false.
     */
    public static boolean login(int ticketID, int meineNummer) {

        try (Connection connection = MySQL.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ticket WHERE ticketID = ?")) {
            statement.setInt(1, ticketID);
            ResultSet rs = statement.executeQuery();
            rs.next();
            int zufNummer = rs.getInt(2);
            if (meineNummer == zufNummer)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
