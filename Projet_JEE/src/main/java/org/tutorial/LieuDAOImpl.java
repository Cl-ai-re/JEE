package org.tutorial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LieuDAOImpl {

	public List<Lieu> findByQueryLieu(String query) {
        List<Lieu> liste_Lieu = new ArrayList<>();
        
        Connection connection = DBManager.getInstance().getConnection();
        Statement statement;
		ResultSet rs;
		
        try {
        	statement = connection.createStatement();
			rs = statement.executeQuery(query);
            while (rs.next()) {
            	Integer ID_Lieu = rs.getInt("ID_Lieu");
            	String Nom_Lieu = rs.getString("Nom_Lieu");
            	String Ville = rs.getString("Ville");
            	String Pays = rs.getString("Pays");
            	String Continent = rs.getString("Continent");
            	
                Lieu Lieu = new Lieu(ID_Lieu, Nom_Lieu, Ville, Pays, Continent);
                
                liste_Lieu.add(Lieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste_Lieu;
    }
	
	public List<Lieu> findByAll() {
		return findByQueryLieu("select * from Lieu");
	}
	
}
