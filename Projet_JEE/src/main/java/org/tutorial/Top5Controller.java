package org.tutorial;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/DJ")
public class Top5Controller {
	
	private DJDAOImpl DJDAOImpl = new DJDAOImpl();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Top5")
	public String getTop5() {
		List<String> lst_DJ;
		try {
			lst_DJ = DJDAOImpl.Top5();
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
