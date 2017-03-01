package com.mocatto.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.mocatto.db.CommentDAO;
import com.mocatto.db.TopicDAO;
import com.mocatto.dto.CommentDTO;
import com.mocatto.dto.TopicDTO;

@Path("{local}/community")
public class CommunityServices {

	@POST
    @Path("saveTopic")
	@Produces("application/json")
	public TopicDTO saveTopic(String topic) {
		Gson gson = new Gson();
		TopicDTO dto = gson.fromJson(topic, TopicDTO.class);
		
		TopicDAO dao = new TopicDAO();
		int id = dao.save(dto);
		dto.setId(id);
		return dto;
	}
	
	@POST
    @Path("saveComment")
	@Produces("application/json")
	public CommentDTO saveComment(String comment) {
		Gson gson = new Gson();
		CommentDTO dto = gson.fromJson(comment, CommentDTO.class);
		
		CommentDAO dao = new CommentDAO();
		int id = dao.save(dto);
		dto.setId(id);
		return dto;
	}
	
	@Path("getTopicsBySpecie/{specie}")
	@GET
	@Produces("application/json")
	public List<TopicDTO> getTopicsBySpecie(@PathParam("specie") int specie) {
		TopicDAO dao = new TopicDAO();
		return dao.getTopicsbySpecie(specie);
	}
	
	@Path("getCommentsByTopic/{topic}")
	@GET
	@Produces("application/json")
	public List<CommentDTO> getCommentsByTopic(@PathParam("topic") int topic) {
		CommentDAO dao = new CommentDAO();
		return dao.getCommentsByTopic(topic);
	}
	
	@Path("getCommentsByComment/{comment}")
	@GET
	@Produces("application/json")
	public List<CommentDTO> getCommentsByComment(@PathParam("comment") int comment) {
		CommentDAO dao = new CommentDAO();
		return dao.getCommentsByComment(comment);
	}
}
