package org.tutorial;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Lieu")
public class LieuController {
		
	private LieuDAOImpl LieuDAOImpl = new LieuDAOImpl();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Liste")
	public String getLieu() {
		List<Lieu> lst_Lieu;
		try {
			lst_Lieu = LieuDAOImpl.findByAll();
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			String json = gson.toJson(lst_Lieu);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occured while loading data";
		}
	}
	
}
