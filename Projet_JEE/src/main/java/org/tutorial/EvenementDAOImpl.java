package org.tutorial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EvenementDAOImpl implements EvenementDAO{
	
	public List<Evenement> findByQueryEvenement(String query) {
        List<Evenement> liste_Evenement = new ArrayList<>();
        
        Connection connection = DBManager.getInstance().getConnection();
        Statement statement;
		ResultSet rs;
		
        try {
        	statement = connection.createStatement();
			rs = statement.executeQuery(query);
            while (rs.next()) {
            	Integer ID_Evenement = rs.getInt("ID_Evenement");
            	Date Date_Evenement = rs.getDate("Date_Evenement");
            	Integer Debut = rs.getInt("Debut");
            	Integer Fin = rs.getInt("Fin");
            	Integer ID_DJ = rs.getInt("ID_DJ");
            	Integer ID_Lieu = rs.getInt("ID_Lieu");
            	
                Evenement Evenement = new Evenement(ID_Evenement, Date_Evenement, Debut, Fin, ID_DJ, ID_Lieu);
                
                liste_Evenement.add(Evenement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste_Evenement;
    }
	
	
	public List<Evenement> findThisMonth (Integer mois) {
		return findByQueryEvenement("CALL EvenementMois ('" + mois + "');");
	}
	
	public List<Evenement> findByDate(String searchText) {
		return findByQueryEvenement("select * from Evenement where Date_evenement like '%" + searchText + "%'");
	}

	public List<Evenement> findByEvenement(String searchText) {
		return findByQueryEvenement("select * from Evenement where ID_Evenement like '%" + searchText + "%'");
	}

	public List<Evenement> findByLieu(String searchText) {
		return findByQueryEvenement("select * from Evenement where ID_Lieu like '%" + searchText + "%'");
	}
	
	// Méthode pour insérer un nouveau Evenement dans la base de données
	public void insertEvenement(Evenement Evenement) {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    
	    try {
	        connection = DBManager.getInstance().getConnection();
	        if (connection == null) {
	            throw new SQLException("La connexion à la base de données a échoué.");
	        }
	        
	        String query = "Insert into Evenement (Nom, Prenom, Pseudo, Date_de_Naissance, Adresse, Continent, Style, Actif) values (?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, Evenement.getID_Evenement());
	        statement.setString(2, Evenement.getDate_Evenement().toString());
	        statement.setInt(3, Evenement.getDebut());
	        statement.setInt(4, Evenement.getFin());
	        statement.setInt(5, Evenement.getID_DJ());
	        statement.setInt(6, Evenement.getID_Lieu());
	        
	        int rowsInserted = statement.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("Un nouveau Evenement a été ajouté à la base de données : " + Evenement);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // On ferme les ressources JDBC dans le finally
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}	
}
