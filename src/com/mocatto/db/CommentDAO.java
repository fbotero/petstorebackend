package com.mocatto.db;

import java.sql.Timestamp;
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

import com.mocatto.dto.CommentDTO;

/**
 * @author luis.botero
 *
 */
@Entity
@Table( name = "COMMENT") 
public class CommentDAO {

	private Integer id;
	private String name;
	private Integer topic;
	private Integer likes;
	private Timestamp date;
	private Integer comment;

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
	@Column(name = "TOPIC_ID", columnDefinition="NUMERIC")
	public Integer getTopic() {
		return topic;
	}
	public void setTopic(Integer topic) {
		this.topic = topic;
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
	@Column(name = "COMMENT_ID", columnDefinition="NUMERIC")
	public Integer getComment() {
		return comment;
	}
	public void setComment(Integer comment) {
		this.comment = comment;
	}
	public int save(CommentDTO comment) {
		Session session = HibernateUtil.currentSession();
		
		CommentDAO dao = new CommentDAO();
		try {
			
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dao, comment);
			
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
	
	public void delete(CommentDTO comment) {
		Session session = HibernateUtil.currentSession();
		
		try {
			CommentDAO dao = new CommentDAO();
			
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dao, comment);
			
			
			session.beginTransaction();
			
			session.delete(dao);
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();
	}
	
	public List<CommentDTO> getCommentsByTopic(int topic) {
		Session session = HibernateUtil.currentSession();
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();

		try {
			session.beginTransaction();

			List<CommentDAO> daoList = (List<CommentDAO>) session.createQuery("from CommentDAO where topic = :topic order by date desc")
					.setParameter("topic", topic).list();
			for (CommentDAO dao : daoList) {
				CommentDTO dto = new CommentDTO();
				BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
				BeanUtils.copyProperties(dto, dao);

				dto.setDate(null);
				commentList.add(dto);
			}

			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		}

		HibernateUtil.closeSession();
		return commentList;
	}
	
	public List<CommentDTO> getCommentsByComment(int comment) {
		Session session = HibernateUtil.currentSession();
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();

		try {
			session.beginTransaction();

			List<CommentDAO> daoList = (List<CommentDAO>) session.createQuery("from CommentDAO where comment = :comment order by date desc")
					.setParameter("comment", comment).list();
			for (CommentDAO dao : daoList) {
				CommentDTO dto = new CommentDTO();
				BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
				BeanUtils.copyProperties(dto, dao);

				dto.setDate(null);
				commentList.add(dto);
			}

			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		}

		HibernateUtil.closeSession();
		return commentList;
	}
}
