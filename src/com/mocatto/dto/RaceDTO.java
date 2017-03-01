package com.mocatto.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RaceDTO {

	private Integer id;
	private Integer specieId;
	private String nameEn;
	private String nameEs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSpecieId() {
		return specieId;
	}
	public void setSpecieId(Integer specieId) {
		this.specieId = specieId;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNameEs() {
		return nameEs;
	}
	public void setNameEs(String nameEs) {
		this.nameEs = nameEs;
	}
}

