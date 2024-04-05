package org.tutorial;

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


@Path("/DJ")
public class DJController {

	//@QueryParam("Nom") String Nom à mettre dans les variables d'entrée d'une méthode
	
	private DJDAOImpl DJDAOImpl = new DJDAOImpl();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Liste")
	public String getDJ() {
		List<DJ> lst_DJ;
		try {
			lst_DJ = DJDAOImpl.findByAll();
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			String json = gson.toJson(lst_DJ);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occured while loading data";
		}
	}
	
	@POST
	@Path("/Ajout")
	@Consumes("application/x-www-form-urlencoded")
	public void createDJ(@FormParam("Nom") String Nom, @FormParam("Prenom") String Prenom, @FormParam("Pseudo") String Pseudo, @FormParam("Date_de_naissance") String Date_de_naissance, @FormParam("Adresse") String Adresse, @FormParam("Continent") String Continent, @FormParam("Style") String Style) {
		DJ nouveau_DJ = new DJ (Nom, Prenom, Pseudo, Date_de_naissance, Adresse, Continent, Style, 1);
		try {
			DJDAOImpl.insertDJ(nouveau_DJ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// On a essayé d'utilisé @DELETE mais on récupérait toujours une erreur 405
	@GET
	@Path("/Suppression")
	public void deleteDJ (@QueryParam("ID_DJ") Integer ID_DJ) {
		try {
			DJDAOImpl.deleteDJ(ID_DJ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/Modification")
	public void updateDJ (@QueryParam("ID_DJ") Integer ID_DJ) {
		//@FormParam("ID_DJ") Integer ID_DJ, @FormParam("Nom") String Nom, @FormParam("Prenom") String Prenom, @FormParam("Pseudo") String Pseudo, @FormParam("Date_de_naissance") String Date_de_naissance, @FormParam("Adresse") String Adresse, @FormParam("Continent") String Continent, @FormParam("Style") String Style)
		DJ modif_DJ = DJDAOImpl.findById(ID_DJ); //= new DJ (Nom, Prenom, Pseudo, Date_de_naissance, Adresse, Continent, Style, 1);
		try {
			DJDAOImpl.updateDJ(modif_DJ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}





}