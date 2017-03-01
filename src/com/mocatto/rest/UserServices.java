package com.mocatto.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.mocatto.db.UserDAO;
import com.mocatto.dto.LoginDTO;
import com.mocatto.dto.UserDTO;

@Path("{local}/user")
public class UserServices {

	@POST
    @Path("saveUser")
	@Produces("application/json")
	public UserDTO saveUser(String user) {
		Gson gson = new Gson();
		UserDTO dto = gson.fromJson(user, UserDTO.class);
		
		UserDAO dao = new UserDAO();
		dao.save(dto);
		return dto;
	}
	
	@POST
    @Path("loginUser")
	@Produces("application/json")
	public UserDTO loginUser(String login) {
		Gson gson = new Gson();
		LoginDTO loginDTO = gson.fromJson(login, LoginDTO.class);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(loginDTO.getEmail());
		userDTO.setPassword(loginDTO.getPassword());
		
		UserDAO dao = new UserDAO();
		return dao.login(userDTO);
	}
}
