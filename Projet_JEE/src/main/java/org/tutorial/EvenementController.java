package org.tutorial;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("/Evenement")
public class EvenementController {
	
	private EvenementDAOImpl EvenementDAOImpl = new EvenementDAOImpl();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Liste")
	public String getEvenement() {
		List<Evenement> lst_Evenement;
		try {		
			LocalDate date = LocalDate.now();
			Integer mois = date.getMonthValue();
			lst_Evenement = EvenementDAOImpl.findThisMonth(mois);
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			String json = gson.toJson(lst_Evenement);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occured while loading data";
		}
	}
	
	@POST
	@Path("/Ajout")
	@Consumes("application/x-www-form-urlencoded")
	public void createEvenement(@FormParam("Date_Evenement") Date Date_Evenement, @FormParam("Debut") Integer Debut, @FormParam("Fin") Integer Fin, @FormParam("Pseudo_DJ") String Pseudo_DJ, @FormParam("Nom_Lieu") String Nom_Lieu) {
		Event nouveau_Evenement = new Event (Date_Evenement, Debut, Fin, Pseudo_DJ, Nom_Lieu);
		System.out.println(Date_Evenement);
		System.out.println(Debut);
		System.out.println(Fin);
		System.out.println(Pseudo_DJ);
		System.out.println(Nom_Lieu);
		try {
			EvenementDAOImpl.insertEvenement(nouveau_Evenement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
