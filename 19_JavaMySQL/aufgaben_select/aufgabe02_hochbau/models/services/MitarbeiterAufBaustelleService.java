package aufgaben_select.aufgabe02_hochbau.models.services;


import aufgaben_select.aufgabe02_hochbau.MySQL;
import aufgaben_select.aufgabe02_hochbau.models.Baustelle;
import aufgaben_select.aufgabe02_hochbau.models.Mitarbeiter;
import aufgaben_select.aufgabe02_hochbau.models.MitarbeiterAufBaustelle;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MitarbeiterAufBaustelleService {
    public static void selectMitarbeiterAufBaustelle()
    {
        try (Connection connection = MySQL.getConnection();
             Statement statement = connection.createStatement())
        {

            ResultSet rs = statement.executeQuery("select * from MA_auf_Baustelle");

            while(rs.next())
            {
                Mitarbeiter mitarbeiter = Mitarbeiter.mitarbeiterMap.get(rs.getString("MANummer"));
                Baustelle baustelle = Baustelle.baustelleMap.get(rs.getString("Baustellennummer"));

                BigDecimal einsatzzeit = rs.getBigDecimal("Einsatzzeit");

                new MitarbeiterAufBaustelle(mitarbeiter, baustelle, einsatzzeit);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
