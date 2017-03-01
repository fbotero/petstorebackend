package com.mocatto.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.mocatto.db.AppointmentDAO;
import com.mocatto.dto.AppointmentDTO;

@Path("{local}/appointment")
public class AppointmentServices {

	@Path("getAppointmentsbyEmail/{email}")
	@GET
	@Produces("application/json")
	public List<AppointmentDTO> getAppointmentsbyEmail(@PathParam("email") String email) {
		AppointmentDAO dao = new AppointmentDAO();
		return dao.getAppointmentsbyEmail(email);
	}
	
	@POST
    @Path("createAppointment")
	@Produces("application/json")
	public AppointmentDTO createAppointment(String appointment) {
		Gson gson = new Gson();
		AppointmentDTO dto = gson.fromJson(appointment, AppointmentDTO.class);
		
		AppointmentDAO dao = new AppointmentDAO();
		dao.createAppointment(dto);
		return dto;
	}
}
