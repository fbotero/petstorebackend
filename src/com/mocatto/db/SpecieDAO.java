package com.mocatto.db;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.cfg.Configuration;

import com.mocatto.dto.SpecieDTO;

@Entity
@Table( name = "SPECIE")
public class SpecieDAO {

	private Integer id;
	private String name;
	private String description;
	
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
  
	@Column(name = "DESCRIPTION", columnDefinition="TEXT")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
    this.description = description;
  }

  /** Return the list of all the Species */
	public List<SpecieDTO> list() {
		Session session = HibernateUtil.currentSession();
		
		session.beginTransaction();
		
		List<SpecieDTO> result = session.createQuery("from SpecieDAO").list();
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
		
		return result;
  }
}
