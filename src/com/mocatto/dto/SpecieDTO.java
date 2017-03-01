package com.mocatto.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SpecieDTO {

	private Integer id;
	private String name;
	private String description;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripion() {
		return description; 
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
