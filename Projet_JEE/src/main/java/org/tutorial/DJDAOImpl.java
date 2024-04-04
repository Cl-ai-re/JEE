package org.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DJDAOImpl implements DJDAO{
	
	public List<DJ> findByQueryDJ(String query) {
        List<DJ> liste_DJ = new ArrayList<>();
        
        Connection connection = DBManager.getInstance().getConnection();
        Statement statement;
		ResultSet rs;
		
        try {
        	statement = connection.createStatement();
			rs = statement.executeQuery(query);
            while (rs.next()) {
            	Integer ID_DJ = rs.getInt("ID_DJ");
                String Nom = rs.getString("Nom");
                String Prenom = rs.getString("Prenom");
                String Pseudo = rs.getString("Pseudo");
                String Date_de_naissance = rs.getString("Date_de_naissance");
                String Adresse = rs.getString("Adresse");
                String Continent = rs.getString("Continent");
                String Style = rs.getString("Style");
                Integer Actif = rs.getInt("Actif");
                
                DJ dj = new DJ(ID_DJ, Nom, Prenom, Pseudo, Date_de_naissance, Adresse, Continent, Style, Actif);
                liste_DJ.add(dj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste_DJ;
    }
	
	
	public List<DJ> findByAll() {
		return findByQueryDJ("select * from DJ");
	}
	
	public List<DJ> findByNom(String searchText) {
		return findByQueryDJ("select * from DJ where Nom like %" + searchText + "%");
	}
	
	public List<DJ> findByPrenom(String searchText) {
		return findByQueryDJ("select * from DJ");
	}
	
	public List<DJ> findByPseudo(String searchText) {
		return findByQueryDJ("select * from DJ");
	}
	
	public List<DJ> findByDate_de_naissance(String searchText) {
		return findByQueryDJ("select * from DJ");
	}
	
	public List<DJ> findByAdresse(String searchText) {
		return findByQueryDJ("select * from DJ");
	}
	
	public List<DJ> findByContinent(String searchText) {
		return findByQueryDJ("select * from DJ");
	}
	
	public List<DJ> findByStyle(String searchText) {
		return findByQueryDJ("select * from DJ");
	}
	
	
	// Méthode pour insérer un nouveau DJ dans la base de données
	public void insertDJ(DJ dj) {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    
	    try {
	        connection = DBManager.getInstance().getConnection();
	        if (connection == null) {
	            throw new SQLException("La connexion à la base de données a échoué.");
	        }
	        
	        String query = "Insert into DJ (Nom, Prenom, Pseudo, Date_de_Naissance, Adresse, Continent, Style, Actif) values (?, ?, ?, ?, ?, ?, ?, ?)";

	        statement = connection.prepareStatement(query);
	        statement.setString(1, dj.getNom());
	        statement.setString(2, dj.getPrenom());
	        statement.setString(3, dj.getPseudo());
	        statement.setString(4, dj.getDate_de_Naissance());
	        statement.setString(5, dj.getAdresse());
	        statement.setString(6, dj.getContinent());
	        statement.setString(7, dj.getStyle());
	        statement.setInt(8, dj.getActif());
	        
	        int rowsInserted = statement.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("Un nouveau DJ a été ajouté à la base de données : " + dj);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // On ferme les ressources JDBC dans le bloc finally
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
	
	// Méthode pour supprimer un DJ de la base de données en utilisant son ID
	public boolean deleteDJ(int ID_DJ) {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    
	    try {
	        connection = DBManager.getInstance().getConnection();
	        if (connection == null) {
	            throw new SQLException("La connexion à la base de données a échoué.");
	        }
	        
	        String query = "DELETE FROM DJ WHERE id = ?";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, ID_DJ);
	        
	        int rowsDeleted = statement.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("DJ avec l'ID : " + ID_DJ + " supprimé de la base de données.");
	            return true;
	        } else {
	            System.out.println("Aucun DJ trouvé avec l'ID : " + ID_DJ + ".");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
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
