package org.tutorial;

import java.util.Date;

public class Evenement {
	private Integer ID_Evenement;
	private Date Date_Evenement;
	private Integer Debut;
	private Integer Fin;
	private Integer ID_DJ;
	private Integer ID_Lieu;
	
	public Evenement (Integer ID_Evenement, Date Date_Evenement, Integer Debut, Integer Fin, Integer ID_DJ, Integer ID_Lieu) {
		this.ID_Evenement = ID_Evenement;
		this.Date_Evenement = Date_Evenement;
		this.Debut = Debut;
		this.Fin = Fin;
		this.ID_DJ = ID_DJ;
		this.ID_Lieu = ID_Lieu;
	}
	public Evenement (Date Date_Evenement, Integer Debut, Integer Fin, Integer ID_DJ, Integer ID_Lieu) {
		this.Date_Evenement = Date_Evenement;
		this.Debut = Debut;
		this.Fin = Fin;
		this.ID_DJ = ID_DJ;
		this.ID_Lieu = ID_Lieu;
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
	public Integer getID_DJ() {
		return ID_DJ;
	}
	public void setID_DJ(Integer iD_DJ) {
		ID_DJ = iD_DJ;
	}
	public Integer getID_Lieu() {
		return ID_Lieu;
	}
	public void setID_Lieu(Integer iD_Lieu) {
		ID_Lieu = iD_Lieu;
	}
}
