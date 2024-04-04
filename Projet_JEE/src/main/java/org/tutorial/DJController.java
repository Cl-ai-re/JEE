package org.tutorial;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("/DJ")
public class DJController {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/hello")
	public String hello() {
		return "Hello World!";
	}

	//@QueryParam("Nom") String Nom à mettre dans les variables d'entrée d'une méthode
	
	
	private DJDAOImpl DJDAOImpl = new DJDAOImpl();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Liste")
	public String getDJ() {
		List<DJ> lst_DJ;
		try {
			lst_DJ =DJDAOImpl.findByAll();
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			String json = gson.toJson(lst_DJ);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occured while loading data";
		}
	}
}
