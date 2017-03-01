package com.mocatto.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.mocatto.db.CityDAO;
import com.mocatto.db.CountryDAO;
import com.mocatto.db.DietDAO;
import com.mocatto.db.FoodBrandDAO;
import com.mocatto.db.RaceDAO;
import com.mocatto.dto.ReturnDTO;

@Path("{local}/util")
public class UtilServices {

	@Path("getFoodBrandList/{specieId}")
	@GET
	@Produces("application/json")
	public List<ReturnDTO> getFoodBrandList(@PathParam("local") String local, @PathParam("specieId") int specieId) {
		FoodBrandDAO dao = new FoodBrandDAO();
		return dao.getFoodBrandList(specieId, local);
	}
	
	@Path("getDietList/{specieId}")
	@GET
	@Produces("application/json")
	public List<ReturnDTO> getDietList(@PathParam("local") String local, @PathParam("specieId") int specieId) {
		DietDAO dao = new DietDAO();
		return dao.getDietList(specieId, local);
	}
	
	@Path("getRaceList/{specieId}")
	@GET
	@Produces("application/json")
	public List<ReturnDTO> getRaceList(@PathParam("local") String local, @PathParam("specieId") int specieId) {
		RaceDAO dao = new RaceDAO();
		return dao.getRaceList(specieId, local);
	}
	
	@Path("getCountryList")
	@GET
	@Produces("application/json")
	public List<ReturnDTO> getCountryList(@PathParam("local") String local) {
		CountryDAO dao = new CountryDAO();
		return dao.getCountryList(local);
	}
	
	@Path("getCityList/{countryId}")
	@GET
	@Produces("application/json")
	public List<ReturnDTO> getCityList(@PathParam("local") String local, @PathParam("countryId") int countryId) {
		CityDAO dao = new CityDAO();
		return dao.getCityList(countryId, local);
	}
}
