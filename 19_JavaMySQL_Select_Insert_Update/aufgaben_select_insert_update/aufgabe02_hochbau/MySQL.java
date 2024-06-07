package aufgaben_select_insert_update.aufgabe02_hochbau;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    private static String connectionString = "jdbc:mysql://localhost:3306/hochbau_sv01";

    public static void setConnectionString(String connectionString) {
        MySQL.connectionString = connectionString;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, "root", "");
    }
}
