package aufgaben_select_insert_update.aufgabe03_ticketautomat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Eine Klasse, die für die Verwaltung der Connection zuständig ist.
 */
public class MySQL {
    private static String connectionString = "jdbc:mysql://localhost:3306/ticketautomat";

    /**
     * Setter für ConnectionString, damit wir die Klasse in anderen Programmen nutzen können und nur den ConnectionString austauschen müssen.
     */
    public static void setConnectionString(String connectionString) {
        MySQL.connectionString = connectionString;
    }

    /**
     * Erstellt und öffnet die Connection.
     *
     * @return Das Connection-Objekt.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, "root", "");
    }


}
