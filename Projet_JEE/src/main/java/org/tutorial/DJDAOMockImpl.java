package org.tutorial;

import java.util.List;

public class DJDAOMockImpl implements DJDAO {

	@Override
	public List<DJ> findByAll() {
		DJ DJ1 = new DJ (1, "Nom_DJ_1", "Prenom_DJ_1", "Pseudo_DJ_1", "1998-09-04" , "Add_DJ_1", "Asie", "Hard Style", 1);
		DJ DJ2 = new DJ (2, "Nom_DJ_2", "Prenom_DJ_2", "Pseudo_DJ_2", "1997-01-22", "Add_DJ_2", "Amérique du Nord", "EDM", 1);
		DJ DJ3 = new DJ (3, "Nom_DJ_3", "Prenom_DJ_3", "Pseudo_DJ_3", "1982-04-09", "Add_DJ_3", "Amérique Centrale", "Hard Style", 1);
		DJ DJ4 = new DJ (4, "Nom_DJ_4", "Prenom_DJ_4", "Pseudo_DJ_4", "2003-01-13", "Add_DJ_4", "Europe", "Hard Style", 1);
		DJ DJ5 = new DJ (5, "Nom_DJ_5", "Prenom_DJ_5", "Pseudo_DJ_5", "2004-12-02", "Add_DJ_5", "Afrique", "EDM", 1);
		List<DJ> liste = List.of(DJ1, DJ2, DJ3, DJ4, DJ5);
		return liste;
	}

	@Override
	public List<DJ> findByNom(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DJ> findByPrenom(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DJ> findByPseudo(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DJ> findByDate_de_naissance(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DJ> findByAdresse(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DJ> findByContinent(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DJ> findByStyle(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

}
