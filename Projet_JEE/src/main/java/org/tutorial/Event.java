package org.tutorial;

import java.util.Date;

public class Event {
	private Integer ID_Evenement;
	private Date Date_Evenement;
	private Integer Debut;
	private Integer Fin;
	private String Pseudo_DJ;
	private String Nom_Lieu;
	
	public Event (Integer ID_Evenement, Date Date_Evenement, Integer Debut, Integer Fin, String Pseudo_DJ, String Nom_Lieu) {
		this.ID_Evenement = ID_Evenement;
		this.Date_Evenement = Date_Evenement;
		this.Debut = Debut;
		this.Fin = Fin;
		this.Pseudo_DJ = Pseudo_DJ;
		this.Nom_Lieu = Nom_Lieu;
	}
	public Event (Date Date_Evenement, Integer Debut, Integer Fin, String Pseudo_DJ, String Nom_Lieu) {
		this.Date_Evenement = Date_Evenement;
		this.Debut = Debut;
		this.Fin = Fin;
		this.Pseudo_DJ = Pseudo_DJ;
		this.Nom_Lieu = Nom_Lieu;
	}
	
	
	public Integer getID_Evenement() {
		return ID_Evenement;
	}
	public void setID_Evenement(Integer iD_Evenement) {
		ID_Evenement = iD_Evenement;
	}
	public Date getDate_Evenement() {
		return Date_Evenement;
	}
	public void setDate_Evenement(Date date_Evenement) {
		Date_Evenement = date_Evenement;
	}
	public Integer getDebut() {
		return Debut;
	}
	public void setDebut(Integer debut) {
		Debut = debut;
	}
	public Integer getFin() {
		return Fin;
	}
	public void setFin(Integer fin) {
		Fin = fin;
	}
	public String getPseudo_DJ() {
		return Pseudo_DJ;
	}
	public void setPseudo_DJ(String pseudo_DJ) {
		Pseudo_DJ = pseudo_DJ;
	}
	public String getNom_Lieu() {
		return Nom_Lieu;
	}
	public void Nom_Lieu(String nom_Lieu) {
		Nom_Lieu = nom_Lieu;
	}
}
