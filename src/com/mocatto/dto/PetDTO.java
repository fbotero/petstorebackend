package com.mocatto.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PetDTO {

	private Integer id;
	private String name;
	private String specie;
	private String race;
	private String gender;
	private Date birthDate;
	private String fur;
	private String diet;
	private String dietName;
	private Integer foodGrams;
	private String foodBrand;
	private String foodBrandName;
	private Integer foodBuyRegularity;
	private Date lastFoodBuyDate;
	private Date lastVaccine;
	private String vaccine;
	private String woopingCough;
	private String woopingCoughDate;
	private Date lastWorm;
	private String antiFlea;
	private Date lastVetVisit;
	private String sterilized;
	private Integer bathFrecuency;
	private Date lastBath;
	private String bathLocation;
	private String others;
	private String event;
	private String regularity;
	private String aidsLeukemiaVaccine;
	private Date aidsLeukemiaVaccineDate;
	private String email;
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
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getFur() {
		return fur;
	}
	public void setFur(String fur) {
		this.fur = fur;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	public String getDietName() {
		return dietName;
	}
	public void setDietName(String dietName) {
		this.dietName = dietName;
	}
	public Integer getFoodGrams() {
		return foodGrams;
	}
	public void setFoodGrams(Integer foodGrams) {
		this.foodGrams = foodGrams;
	}
	public String getFoodBrand() {
		return foodBrand;
	}
	public void setFoodBrand(String foodBrand) {
		this.foodBrand = foodBrand;
	}
	public String getFoodBrandName() {
		return foodBrandName;
	}
	public void setFoodBrandName(String foodBrandName) {
		this.foodBrandName = foodBrandName;
	}
	public Integer getFoodBuyRegularity() {
		return foodBuyRegularity;
	}
	public void setFoodBuyRegularity(Integer foodBuyRegularity) {
		this.foodBuyRegularity = foodBuyRegularity;
	}
	public Date getLastFoodBuyDate() {
		return lastFoodBuyDate;
	}
	public void setLastFoodBuyDate(Date lastFoodBuyDate) {
		this.lastFoodBuyDate = lastFoodBuyDate;
	}
	public Date getLastVaccine() {
		return lastVaccine;
	}
	public void setLastVaccine(Date lastVaccine) {
		this.lastVaccine = lastVaccine;
	}
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	public String getWoopingCough() {
		return woopingCough;
	}
	public void setWoopingCough(String woopingCough) {
		this.woopingCough = woopingCough;
	}
	public String getWoopingCoughDate() {
		return woopingCoughDate;
	}
	public void setWoopingCoughDate(String woopingCoughDate) {
		this.woopingCoughDate = woopingCoughDate;
	}
	public Date getLastWorm() {
		return lastWorm;
	}
	public void setLastWorm(Date lastWorm) {
		this.lastWorm = lastWorm;
	}
	public String getAntiFlea() {
		return antiFlea;
	}
	public void setAntiFlea(String antiFlea) {
		this.antiFlea = antiFlea;
	}
	public Date getLastVetVisit() {
		return lastVetVisit;
	}
	public void setLastVetVisit(Date lastVetVisit) {
		this.lastVetVisit = lastVetVisit;
	}
	public String getSterilized() {
		return sterilized;
	}
	public void setSterilized(String sterilized) {
		this.sterilized = sterilized;
	}
	public Integer getBathFrecuency() {
		return bathFrecuency;
	}
	public void setBathFrecuency(Integer bathFrecuency) {
		this.bathFrecuency = bathFrecuency;
	}
	public Date getLastBath() {
		return lastBath;
	}
	public void setLastBath(Date lastBath) {
		this.lastBath = lastBath;
	}
	public String getBathLocation() {
		return bathLocation;
	}
	public void setBathLocation(String bathLocation) {
		this.bathLocation = bathLocation;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getRegularity() {
		return regularity;
	}
	public void setRegularity(String regularity) {
		this.regularity = regularity;
	}
	public String getAidsLeukemiaVaccine() {
		return aidsLeukemiaVaccine;
	}
	public void setAidsLeukemiaVaccine(String aidsLeukemiaVaccine) {
		this.aidsLeukemiaVaccine = aidsLeukemiaVaccine;
	}
//	public String getAidsLeukemiaVaccineDate() {
//		return aidsLeukemiaVaccineDate;
//	}
//	public void setAidsLeukemiaVaccineDate(String aidsLeukemiaVaccineDate) {
//		this.aidsLeukemiaVaccineDate = aidsLeukemiaVaccineDate;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
