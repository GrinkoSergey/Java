package aufgaben.aufgabe01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class Service {
    /* Die Aufgabe: Erstellen Sie für die Kunden Insert- und Update-Prozeduren in MySQL und implementieren Sie in Java die entsprechenden Methoden */
    //////////////////////////////////////////////////
    // insertKunde

    /**
     * Führt die Prozedur "insertKunde" aus und gibt die durch AUTO_INCREMENT erstellte Kundennummer zurück.
     * @return Die erzeugte Kundennummer.
     */
    public static int insertKunde(String name) {

        try (Connection connection = MySQL.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL insertKunde(?,?)}")) {

            statement.setString(1,name);
            statement.registerOutParameter(2, Types.INTEGER);

            if(statement.executeUpdate() > 0)
                return statement.getInt(2);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }

    //////////////////////////////////////////////////
    // updateKunde

    static String verbindung = "jdbc:mysql://localhost:3306/onlineshop";
    /**
     * Führt die Prozedur "updateKunde" aus und gibt die Anzahl der betroffenen Datensätze zurück.
     * @return Die Anzahl der betroffenen Datensätze
     */
    public static int updateKunde(int kundennummer, String name) {

        try (Connection connection = DriverManager.getConnection(verbindung, "root", "");
             // Connection connection = MySQL.getConnection();
            CallableStatement statement = connection.prepareCall("{CALL updateKunde(?,?)}");
            // Optional
            PreparedStatement statement2 = connection.prepareStatement("SELECT * from Kunde WHERE kundennummer = ?")) {

            statement.setInt(1, kundennummer);
            statement.setString(2, name);

            int anzahl = statement.executeUpdate();

            // Optional
            statement2.setInt(1,kundennummer);
            ResultSet rs = statement2.executeQuery();

            if (rs.next()) {
                System.out.println("Der neue " + Character.toUpperCase(rs.getMetaData().getColumnName(2).charAt(0)) + rs.getMetaData().getColumnName(2).substring(1) + ": " + rs.getString("name"));
            }
            ///////////////////////

            return anzahl;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
