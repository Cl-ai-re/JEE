package org.tutorial;

import java.util.List;

public interface DJDAO {
	List<DJ> findByAll();
	List<DJ> findByNom(String searchText);
	List<DJ> findByPrenom(String searchText);
	List<DJ> findByPseudo(String searchText);
	List<DJ> findByDate_de_naissance(String searchText);
	List<DJ> findByAdresse(String searchText);
	List<DJ> findByContinent(String searchText);
	List<DJ> findByStyle(String searchText);
}
