package aufgaben.aufgabe01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQL {
    private static String connectionString = "jdbc:mysql://localhost:3306/onlineshop";

    public static void setConnectionString(String connectionString) {
        MySQL.connectionString = connectionString;
    }

    /**
     * Erstellt und öffnet die Connection.
     * @return Das Connection-Objekt.
     */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(connectionString, "root", "");
    }


}
