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
@Table( name = "COUNTRY")
public class CountryDAO {

	private Integer id;
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
    /** Return the list of all the Countries */
	public List<ReturnDTO> getCountryList(String local) {
		Session session = HibernateUtil.currentSession();

		List<ReturnDTO> resultList = new ArrayList<ReturnDTO>();
		try {
			session.beginTransaction();
			
			List<CountryDAO> daoList = (List<CountryDAO>) session.createQuery("from CountryDAO").list();
			for (CountryDAO dao : daoList) {
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
