package com.mocatto.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.annotations.GenericGenerator;

import com.mocatto.dto.ReturnDTO;

@Entity
@Table( name = "CITY")
public class CityDAO {

	private Integer id;
	private Integer countryId;
	private String nameEn;
	private String nameEs;
	
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
	@Column(name = "COUNTRY_ID", columnDefinition="NUMERIC")
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	@Column(name = "NAME_EN", columnDefinition="TEXT")
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	@Column(name = "NAME_ES", columnDefinition="TEXT")
	public String getNameEs() {
		return nameEs;
	}
	public void setNameEs(String nameEs) {
		this.nameEs = nameEs;
	}
    /** Return the list of all the contries that belongs to an specific city */
	public List<ReturnDTO> getCityList(Integer countryId, String local) {
		Session session = HibernateUtil.currentSession();

		List<ReturnDTO> resultList = new ArrayList<ReturnDTO>();
		try {
			session.beginTransaction();
			
			List<CityDAO> daoList = (List<CityDAO>) session.createQuery("from CityDAO where countryId = :countryId").setParameter("countryId", countryId).list();
			for (CityDAO dao : daoList) {
				ReturnDTO dto = new ReturnDTO();
				
				dto.setId(dao.getId());
				
				if (local != null && local.equals("es")) {
					dto.setName(dao.getNameEs());
				} else {
					dto.setName(dao.getNameEn());
				}
	      
				resultList.add(dto);
			}
			
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();
		return resultList;
  }
}
