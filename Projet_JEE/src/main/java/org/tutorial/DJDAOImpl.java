package org.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
	
	
	public List<String> findByQueryPseudo(String query){
        List<String> liste_DJ = new ArrayList<>();
        
        Connection connection = DBManager.getInstance().getConnection();
        Statement statement;
		ResultSet rs;
		
        try {
        	statement = connection.createStatement();
			rs = statement.executeQuery(query);
			for (var i = 1; i <= 5; i++) {
				System.out.println(rs.getString(i));
				liste_DJ.add(rs.getString(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste_DJ;
    }
	
	public List<DJ> findByAll() {
		return findByQueryDJ("select * from DJ");
	}
	
	public List<String> Top5() {
		return findByQueryPseudo("CALL Top5();");
	}
	
	public DJ findById(Integer ID_DJ) {
		return findByQueryDJ("select * from DJ where ID_DJ = " + ID_DJ.toString() + ";").get(0);
	}
	
	public List<DJ> findByNom(String searchText) {
		return findByQueryDJ("select * from DJ where Nom like '%" + searchText + "%'");
	}

	public List<DJ> findByPrenom(String searchText) {
		return findByQueryDJ("select * from DJ where Prenom like '%" + searchText + "%'");
	}

	public List<DJ> findByPseudo(String searchText) {
		return findByQueryDJ("select * from DJ where Pseudo like '%" + searchText + "%'");
	}

	public List<DJ> findByDate_de_naissance(String searchText) {
		return findByQueryDJ("select * from DJ where Date_de_naissance like '%" + searchText + "%'");
	}

	public List<DJ> findByAdresse(String searchText) {
		return findByQueryDJ("select * from DJ where Adresse like '%" + searchText + "%'");
	}

	public List<DJ> findByContinent(String searchText) {
		return findByQueryDJ("select * from DJ where Continent like '%" + searchText + "%'");
	}

	public List<DJ> findByStyle(String searchText) {
		return findByQueryDJ("select * from DJ where Style like '%" + searchText + "%'");
	}

	/*
	public List<Evenement> findByDate(String searchText) {
		return findByQueryEvenement("select * from Evenement where Date_evenement like '%" + searchText + "%'");
	}

	public List<Evenement> findByDJ(String searchText) {
		return findByQueryEvenement("select * from Evenement where ID_Evenement like '%" + searchText + "%'");
	}

	public List<Evenement> findByLieu(String searchText) {
		return findByQueryEvenement("select * from Evenement where ID_Lieu like '%" + searchText + "%'");
	*/
	
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
	// Il s'agit plus d'une désactivation que d'une suppression en fait.
	// On désactive seulement le DJ car il s'agit d'une clé étrangère dans les tables.
	// Cela évite de devoir supprimer toutes les ressources qui lui sont associées.
	public void deleteDJ(Integer ID_DJ) {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    
	    try {
	        connection = DBManager.getInstance().getConnection();
	        if (connection == null) {
	            throw new SQLException("La connexion à la base de données a échoué.");
	        }
	        System.out.println(ID_DJ);
	        String query = "CALL supp_DJ (?);";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, ID_DJ);
	        
	        int rowsDeleted = statement.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("DJ avec l'ID : " + ID_DJ + " désactivé dans la base de données.");
	        } else {
	            System.out.println("Aucun DJ trouvé avec l'ID : " + ID_DJ + ".");
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
	
	public void updateDJ(DJ dj) {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    
	    try {
	        connection = DBManager.getInstance().getConnection();
	        if (connection == null) {
	            throw new SQLException("La connexion à la base de données a échoué.");
	        }
	        
	        String query = "CALL modif_DJ('?','?','?','?','?','?','?','?','?');";
	        
	        
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, dj.getID_DJ());
	        statement.setString(2, dj.getNom());
	        statement.setString(3, dj.getPrenom());
	        statement.setString(4, dj.getPseudo());
	        statement.setString(5, dj.getDate_de_Naissance());
	        statement.setString(6, dj.getAdresse());
	        statement.setString(7, dj.getContinent());
	        statement.setString(8, dj.getStyle());
	        statement.setInt(9, dj.getActif());
	        
	        int rowsDeleted = statement.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("DJ avec l'ID : " + dj.getID_DJ() + " modifié dans la base de données.");
	        } else {
	            System.out.println("Aucun DJ trouvé avec l'ID : " + dj.getID_DJ() + ".");
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
