package com.mocatto.db;

import java.sql.Timestamp;
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
import org.hibernate.annotations.GenericGenerator;

import com.mocatto.dto.TopicDTO;


@Entity
@Table( name = "TOPIC") 
public class TopicDAO {

	private Integer id;
	private Integer specieId;
	private String title;
	private String description;
	private String author;
	private Integer likes;
	private Timestamp date;
	
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
	@Column(name = "SPECIE", columnDefinition="NUMERIC")
	public Integer getSpecieId() {
		return specieId;
	}
	public void setSpecieId(Integer specieId) {
		this.specieId = specieId;
	}
	@Column(name = "TITLE", columnDefinition="TEXT")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "DESCRIPTION", columnDefinition="TEXT")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "AUTHOR", columnDefinition="TEXT")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(name = "LIKES", columnDefinition="NUMERIC")
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	@Column(name = "DATE", columnDefinition="TIMESTAMP")
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int save(TopicDTO topic) {
		Session session = HibernateUtil.currentSession();
		
		TopicDAO dao = new TopicDAO();
		try {
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dao, topic);
			
			if (dao.getId() == null || dao.getId() == 0) {
				dao.setId(null);
			}
			
			// Fecha ultima modificación
			dao.setDate(new Timestamp(System.currentTimeMillis()));
			
			
			session.beginTransaction();
			
			session.saveOrUpdate(dao);
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();
		return dao.getId();
	}
	
	public void delete(TopicDTO topic) {
		Session session = HibernateUtil.currentSession();
		
		try {
			TopicDAO dao = new TopicDAO();
			
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dao, topic);
			
			
			session.beginTransaction();
			
			session.delete(dao);
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();
	}
	
	public List<TopicDTO> getTopicsbySpecie(int specie) {
		Session session = HibernateUtil.currentSession();
		List<TopicDTO> topicList = new ArrayList<TopicDTO>();

		try {
			session.beginTransaction();

			List<TopicDAO> daoList = (List<TopicDAO>) session.createQuery("from TopicDAO where specieId = :specieId order by date desc")
					.setParameter("specieId", specie).list();
			
			for (TopicDAO dao : daoList) {
				TopicDTO dto = new TopicDTO();
				BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
				BeanUtils.copyProperties(dto, dao);

				dto.setDate(null); 
				topicList.add(dto);
			}

			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		}

		HibernateUtil.closeSession();
		return topicList;
	}
}
