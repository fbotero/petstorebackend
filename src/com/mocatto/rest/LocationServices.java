package com.mocatto.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.mocatto.db.LocationDAO;
import com.mocatto.dto.LocationDTO;
import com.mocatto.dto.LocationQueryDTO;

@Path("{local}/location")
public class LocationServices {

	@Path("listLocations")
	@GET
	@Produces("application/json")
	public List<LocationDTO> listLocations() {
		LocationDAO dao = new LocationDAO();
		return dao.listLocations();
	}
	
	@Path("listLocationsParams")
	@GET
	@Produces("application/json")
	public List<LocationDTO> listLocations(String locationsQuery) {
		LocationDAO dao = new LocationDAO();
		return dao.listLocations();
	}

	
	@Path("listLocationsParams")
	@POST
	@Produces("application/json")
	public List<LocationDTO> listLocationsPost(String locationsQuery) {
		Gson gson = new Gson();
		LocationQueryDTO dto = gson.fromJson(locationsQuery, LocationQueryDTO.class);
		
		LocationDAO dao = new LocationDAO();
		return dao.listLocations(dto);
	}
	
}