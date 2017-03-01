package com.mocatto.rest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.mocatto.db.AdvertisingDAO;
import com.mocatto.dto.AdvertisingDTO;

@Path("{local}/advertising")
public class AdvertisingServices {

	@Path("getAdvertisingImage")
	@GET
	@Produces("image/png")
	public Response getPetName(@PathParam("local") String local) throws IOException {
		
		
		BufferedImage image = ImageIO.read(new File("C:\\vipet.png"));

	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(image, "png", baos);
	    byte[] imageData = baos.toByteArray();

	    // uncomment line below to send non-streamed
	    return Response.ok(imageData).build();

	    // uncomment line below to send streamed
	    // return Response.ok(new ByteArrayInputStream(imageData)).build();
	}
	
	@Path("getAdvertising")
	@GET
	@Produces("application/json")
	public AdvertisingDTO getAdvertising(@PathParam("local") String local) throws IOException {
		AdvertisingDAO dao = new AdvertisingDAO();
		
		AdvertisingDTO dto = dao.getActiveAdvertising(true);
		
		if (dto.getId() != null && dto.getId() != -1) { 
			int timesShowed = dto.getTimesShowed() + 1;
			
			dto.setTimesShowed(timesShowed);
			// Would be false when the desired number of times is reached and disable itself. 
			dto.setActive(timesShowed <= dto.getTimesToShow());  
			
			dao.save(dto);
		}	
		
		return dto;
	}
	
}
