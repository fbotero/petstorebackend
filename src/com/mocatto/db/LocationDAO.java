package com.mocatto.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.cfg.Configuration;

import com.mocatto.dto.LocationDTO;
import com.mocatto.dto.LocationQueryDTO;

@Entity
@Table( name = "LOCATION")
public class LocationDAO {

	private Integer id;
	private String name;
	private String address;
	private String telephone;
	private Double longitude;
	private Double latitude;
	private String hours;
	private String city;
	private String image;
	private String store;
	private String vet;
	private String hotel;
	private String spa;
	private String petFriendly;
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
	@Column(name = "ADDRESS", columnDefinition="TEXT")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "TELEPHONE", columnDefinition="TEXT")
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(name = "LONGITUDE", columnDefinition="DOUBLE")
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	@Column(name = "LATITUDE", columnDefinition="DOUBLE")
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	@Column(name = "HOURS", columnDefinition="TEXT")
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	@Column(name = "CITY", columnDefinition="TEXT")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "IMAGE", columnDefinition="TEXT")
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Column(name = "STORE", columnDefinition="TEXT")
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	@Column(name = "VET", columnDefinition="TEXT")
	public String getVet() {
		return vet;
	}
	public void setVet(String vet) {
		this.vet = vet;
	}
	@Column(name = "HOTEL", columnDefinition="TEXT")
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	@Column(name = "SPA", columnDefinition="TEXT")
	public String getSpa() {
		return spa;
	}
	public void setSpa(String spa) {
		this.spa = spa;
	}
	@Column(name = "PET_FRIENDLY", columnDefinition="TEXT")
	public String getPetFriendly() {
		return petFriendly;
	}
	public void setPetFriendly(String petFriendly) {
		this.petFriendly = petFriendly;
	}
	public List<LocationDTO> listLocations() {
		Session session = HibernateUtil.currentSession();
		List<LocationDTO> locationList = new ArrayList<LocationDTO>();
		
		try {
			session.beginTransaction();
			
			List<LocationDAO> daoList = (List<LocationDAO>) session.createQuery("from LocationDAO").list();// where city = :city").setParameter("city", "Medellín").list();
			for (LocationDAO dao : daoList) {
				LocationDTO dto = new LocationDTO();
				
				BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
				BeanUtils.copyProperties(dto, dao);
	      
				locationList.add(dto); 
			}
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();
		return locationList;
	}
	
	public List<LocationDTO> listLocations(LocationQueryDTO queryDTO) {
		Session session = HibernateUtil.currentSession();
		List<LocationDTO> locationList = new ArrayList<LocationDTO>();
		
		try {
			session.beginTransaction();
			
			StringBuilder builder = new StringBuilder();
			builder.append("from LocationDAO");
			
			if (queryDTO.getStore() != null) {
				builder.append(" where store = 'SI'");
			} else if (queryDTO.getVets() != null) {
				builder.append(" where vet = 'SI'");
			} else if (queryDTO.getDayCare() != null) {
				builder.append(" where hotel = 'SI'");
			}else if (queryDTO.getSpa() != null) {
				builder.append(" where spa = 'SI'");
			}else if (queryDTO.getPetFriendly() != null) {
				builder.append(" where petFriendly = 'SI'");
			}else if (queryDTO.getEmergency() != null) {
				builder.append(" where hours = 'SI'");
			} 
			
//			Query query = session.createQuery("from LocationDAO where city = :city");
//			query.
			
//			List<LocationDAO> daoList = (List<LocationDAO>) session.createQuery("from LocationDAO").list();
			List<LocationDAO> daoList = (List<LocationDAO>) session.createQuery(builder.toString()).list();
			for (LocationDAO dao : daoList) {
				LocationDTO dto = new LocationDTO();
				
				BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
				BeanUtils.copyProperties(dto, dao);
	      
				locationList.add(dto);
			}
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		HibernateUtil.closeSession();		
		return locationList;
	}
}
