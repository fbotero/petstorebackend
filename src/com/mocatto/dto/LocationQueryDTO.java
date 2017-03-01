package com.mocatto.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LocationQueryDTO {

	private String store;
	private String vets;
	private String dayCare;
	private String spa;
	private String petFriendly;
	private String emergency;
	private String city;
	private String country;
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getVets() {
		return vets;
	}
	public void setVets(String vets) {
		this.vets = vets;
	}
	public String getDayCare() {
		return dayCare;
	}
	public void setDayCare(String dayCare) {
		this.dayCare = dayCare;
	}
	public String getSpa() {
		return spa;
	}
	public void setSpa(String spa) {
		this.spa = spa;
	}
	public String getPetFriendly() {
		return petFriendly;
	}
	public void setPetFriendly(String petFriendly) {
		this.petFriendly = petFriendly;
	}
	public String getEmergency() {
		return emergency;
	}
	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
