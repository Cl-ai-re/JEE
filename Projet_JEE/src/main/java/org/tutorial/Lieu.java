package org.tutorial;

public class Lieu {
	private Integer ID_Lieu;
	private String Nom_Lieu;
	private String Ville;
	private String Pays;
	private String Continent;
	
	
	public Lieu (Integer ID_Lieu, String Nom_Lieu, String Ville, String Pays, String Continent) {
		this.ID_Lieu = ID_Lieu;
		this.Nom_Lieu = Nom_Lieu;
		this.Ville = Ville;
		this.Pays = Pays;
		this.Continent = Continent;
	}	
	
	public Lieu (String Nom_Lieu, String Ville, String Pays, String Continent) {
		this.Nom_Lieu = Nom_Lieu;
		this.Ville = Ville;
		this.Pays = Pays;
		this.Continent = Continent;
	}
	
	
	
	public Integer getID_Lieu() {
		return ID_Lieu;
	}
	public void setID_Lieu(Integer iD_Lieu) {
		ID_Lieu = iD_Lieu;
	}
	public String getNom_Lieu() {
		return Nom_Lieu;
	}
	public void setNom_Lieu(String nom_Lieu) {
		Nom_Lieu = nom_Lieu;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	public String getContinent() {
		return Continent;
	}
	public void setContinent(String continent) {
		Continent = continent;
	}		

























}
