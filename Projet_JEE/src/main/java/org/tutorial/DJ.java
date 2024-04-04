package org.tutorial;

public class DJ {
	private int ID_DJ;
	private String Nom;
	private String Prenom;
	private String Pseudo;
	private String Date_de_Naissance;
	private String Adresse;
	private String Continent;
	private String Style;
	private Integer Actif;
	
	
	public DJ(int Id, String Nom,String Prenom,String Pseudo, String DateNaissance, String LieuResidence, String Continent, String StyleMusical, Integer Actif) {
		this.ID_DJ = Id;
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.Pseudo = Pseudo;
		this.Date_de_Naissance = DateNaissance;
		this.Adresse = LieuResidence;
		this.Continent = Continent;
		this.Style = StyleMusical;
		this.Actif = Actif;
	}


	public int getID_DJ() {
		return ID_DJ;
	}


	public void setID_DJ(int iD_DJ) {
		ID_DJ = iD_DJ;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public String getPrenom() {
		return Prenom;
	}


	public void setPrenom(String prenom) {
		Prenom = prenom;
	}


	public String getPseudo() {
		return Pseudo;
	}


	public void setPseudo(String pseudo) {
		Pseudo = pseudo;
	}


	public String getDate_de_Naissance() {
		return Date_de_Naissance;
	}


	public void setDate_de_naissance(String date_de_Naissance) {
		Date_de_Naissance = date_de_Naissance;
	}


	public String getAdresse() {
		return Adresse;
	}


	public void setAdresse(String adresse) {
		Adresse = adresse;
	}


	public String getContinent() {
		return Continent;
	}


	public void setContinent(String continent) {
		Continent = continent;
	}


	public String getStyle() {
		return Style;
	}


	public void setStyle(String style) {
		Style = style;
	}


	public Integer getActif() {
		return Actif;
	}


	public void setActif(Integer actif) {
		Actif = actif;
	}
	
	

}
