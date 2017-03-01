package com.mocatto.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.hibernate.Session;
import org.hibernate.annotations.GenericGenerator;
import org.postgresql.largeobject.LargeObjectManager;

import com.mocatto.dto.PetDTO;

@Entity
@Table( name = "PET") 
public class PetDAO {

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
	private Date woopingCoughDate;
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

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "NAME", columnDefinition="TEXT")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "SPECIE", columnDefinition="TEXT")
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	@Column(name = "RACE", columnDefinition="TEXT")
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	@Column(name = "GENDER", columnDefinition="TEXT")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name = "DIET", columnDefinition="TEXT")
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	@Column(name = "FOOD_BRAND", columnDefinition="TEXT")
	public String getFoodBrand() {
		return foodBrand;
	}
	public void setFoodBrand(String foodBrand) {
		this.foodBrand = foodBrand;
	}
	@Column(name = "FOOD_GRAMS", columnDefinition="NUMERIC")
	public Integer getFoodGrams() {
		return foodGrams;
	}
	public void setFoodGrams(Integer foodGrams) {
		this.foodGrams = foodGrams;
	}
	@Column(name = "LAST_WORM", columnDefinition="DATE")
	public Date getLastWorm() {
		return lastWorm;
	}
	public void setLastWorm(Date lastWorm) {
		this.lastWorm = lastWorm;
	}
	@Column(name = "LAST_VACCINE", columnDefinition="DATE")
	public Date getLastVaccine() {
		return lastVaccine;
	}
	public void setLastVaccine(Date lastVaccine) {
		this.lastVaccine = lastVaccine;
	}
	@Column(name = "BATH_LOCATION", columnDefinition="TEXT")
	public String getBathLocation() {
		return bathLocation;
	}
	public void setBathLocation(String bathLocation) {
		this.bathLocation = bathLocation;
	}
	/* DESDE ACA */
	@Column(name = "BIRTH_DATE", columnDefinition="DATE")
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Column(name = "FUR", columnDefinition="TEXT")
	public String getFur() {
		return fur;
	}
	public void setFur(String fur) {
		this.fur = fur;
	}
	@Column(name = "DIET_NAME", columnDefinition="TEXT")
	public String getDietName() {
		return dietName;
	}
	public void setDietName(String dietName) {
		this.dietName = dietName;
	}
	@Column(name = "FOOD_BRAND_NAME", columnDefinition="TEXT")
	public String getFoodBrandName() {
		return foodBrandName;
	}
	public void setFoodBrandName(String foodBrandName) {
		this.foodBrandName = foodBrandName;
	}
	@Column(name = "FOOD_BUY_REGULARITY", columnDefinition="NUMERIC")
	public Integer getFoodBuyRegularity() {
		return foodBuyRegularity;
	}
	public void setFoodBuyRegularity(Integer foodBuyRegularity) {
		this.foodBuyRegularity = foodBuyRegularity;
	}
	@Column(name = "LAST_FOOD_BUY_DATE", columnDefinition="DATE")
	public Date getLastFoodBuyDate() {
		return lastFoodBuyDate;
	}
	public void setLastFoodBuyDate(Date lastFoodBuyDate) {
		this.lastFoodBuyDate = lastFoodBuyDate;
	}
	@Column(name = "VACCINE", columnDefinition="TEXT")
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	@Column(name = "WOOPING_COUGH", columnDefinition="TEXT")
	public String getWoopingCough() {
		return woopingCough;
	}
	public void setWoopingCough(String woopingCough) {
		this.woopingCough = woopingCough;
	}
	@Column(name = "WOOPING_COUGH_DATE", columnDefinition="DATE")
	public Date getWoopingCoughDate() {
		return woopingCoughDate;
	}
	public void setWoopingCoughDate(Date woopingCoughDate) {
		this.woopingCoughDate = woopingCoughDate;
	}
	@Column(name = "ANTI_FLEA", columnDefinition="TEXT")
	public String getAntiFlea() {
		return antiFlea;
	}
	public void setAntiFlea(String antiFlea) {
		this.antiFlea = antiFlea;
	}
	@Column(name = "LAST_VET_VISIT", columnDefinition="DATE")
	public Date getLastVetVisit() {
		return lastVetVisit;
	}
	public void setLastVetVisit(Date lastVetVisit) {
		this.lastVetVisit = lastVetVisit;
	}
	@Column(name = "STERILIZED", columnDefinition="TEXT")
	public String getSterilized() {
		return sterilized;
	}
	public void setSterilized(String sterilized) {
		this.sterilized = sterilized;
	}
	@Column(name = "BATH_FRECUENCY", columnDefinition="NUMERIC")
	public Integer getBathFrecuency() {
		return bathFrecuency;
	}
	public void setBathFrecuency(Integer bathFrecuency) {
		this.bathFrecuency = bathFrecuency;
	}
	@Column(name = "LAST_BATH", columnDefinition="DATE")
	public Date getLastBath() {
		return lastBath;
	}
	public void setLastBath(Date lastBath) {
		this.lastBath = lastBath;
	}
	@Column(name = "OTHERS", columnDefinition="TEXT")
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	@Column(name = "EVENTS", columnDefinition="TEXT")
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	@Column(name = "REGULARITY", columnDefinition="TEXT")
	public String getRegularity() {
		return regularity;
	}
	public void setRegularity(String regularity) {
		this.regularity = regularity;
	}
	@Column(name = "AIDS_LEUKEMIA_VACCINE", columnDefinition="TEXT")
	public String getAidsLeukemiaVaccine() {
		return aidsLeukemiaVaccine;
	}
	public void setAidsLeukemiaVaccine(String aidsLeukemiaVaccine) {
		this.aidsLeukemiaVaccine = aidsLeukemiaVaccine;
	}
	@Column(name = "AIDS_LEUKEMIA_VACCINE_DATE", columnDefinition="date")
	public Date getaidsleukemiavaccinedate() {
		return aidsLeukemiaVaccineDate;
	}
	public void setaidsleukemiavaccinedate(Date aidsleukemiavaccinedate) {
		this.aidsLeukemiaVaccineDate = aidsleukemiavaccinedate;
	}
	@Column(name = "EMAIL", columnDefinition="TEXT")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int save(PetDTO pet) {
		Session session = HibernateUtil.currentSession();
		
		PetDAO dao = new PetDAO();
		try {
			
			
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dao, pet);
			
			if (dao.getId() == null || dao.getId() == 0) {
				dao.setId(null);
			}
			
			session.beginTransaction();
			
			session.saveOrUpdate(dao);
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();
		return dao.getId();
	}
	
	public void delete(PetDTO pet) {
		Session session = HibernateUtil.currentSession();
		
		try {
			PetDAO dao = new PetDAO();
			
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dao, pet);
			
			
			session.beginTransaction();
			
			session.delete(dao);
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();
	}
	
	public List<PetDTO> list() {
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		
		List<PetDTO> result = session.createQuery("from PetDAO").list();
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
		
		return result;
	}
	
	public PetDTO getPetbyId(int id) {
		Session session = HibernateUtil.currentSession();
		PetDTO dto = new PetDTO();
		
		try {
			session.beginTransaction();
			
			PetDAO dao = (PetDAO) session.createQuery("from PetDAO where id = :id").setParameter("id", 1).uniqueResult();
			
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dto, dao);
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();		
		return dto;
	}
	
  public List<PetDTO> getPetbyEmail(String email) {
	  	Session session = HibernateUtil.currentSession();
		List<PetDTO> petList = new ArrayList<PetDTO>();
		
		try{
			session.beginTransaction();
			
			List<PetDAO> daoList = (List<PetDAO>) session.createQuery("from PetDAO where email = :email").setParameter("email", email).list();
			for (PetDAO dao : daoList) {
				PetDTO dto = new PetDTO();
				BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
				BeanUtils.copyProperties(dto, dao);
	      
				petList.add(dto);
			}
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();		
		return petList;
	}
}
