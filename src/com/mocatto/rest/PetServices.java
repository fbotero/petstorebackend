package com.mocatto.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.mocatto.db.PetDAO;
import com.mocatto.dto.PetDTO;

@Path("{local}/pet")
public class PetServices {

	@Path("getPetName")
	@GET
	@Produces("application/json")
	public String getPetName(@PathParam("local") String local) {
		System.out.println("++++++ LOCAL ++++++" + local);
		String name = "Mocatto";
		return name;
	}
	
	@Path("getPet/{id}")
	@GET
	@Produces("application/json")
	public PetDTO getPetById(@PathParam("id") int id) {
		PetDAO dao = new PetDAO();
		return dao.getPetbyId(id);
	}
	
	@Path("getPetsByEmail/{email}")
	@GET
	@Produces("application/json")
	public List<PetDTO> getPetById(@PathParam("email") String email) {
		PetDAO dao = new PetDAO();
		return dao.getPetbyEmail(email);
	}
	
	@POST
    @Path("savePet")
	@Produces("application/json")
	public PetDTO savePet(String pet) {
		Gson gson = new Gson();
		PetDTO dto = gson.fromJson(pet, PetDTO.class);
		
		PetDAO dao = new PetDAO();
		int id = dao.save(dto);
		dto.setId(id);
		return dto;
	}
	
	@Path("deletePet/{id}")
	@GET
	@Produces("application/json")
	public void deletePet(@PathParam("id") int id) {
		PetDAO dao = new PetDAO();
		PetDTO dto = dao.getPetbyId(id);
		dao.delete(dto);
	}
}
