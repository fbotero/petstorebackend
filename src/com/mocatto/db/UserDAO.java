package com.mocatto.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mocatto.dto.UserDTO;

@Entity
@Table( name = "USER")
public class UserDAO {
	
	private String email;
	private String name;
	private String password;
	private String telephone;
	
	@Id
	@Column(name = "EMAIL", columnDefinition="TEXT")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "NAME", columnDefinition="TEXT")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "PASSWORD", columnDefinition="TEXT")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "TELEPHONE", columnDefinition="TEXT")
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void save(UserDTO user) {
		Session session = HibernateUtil.currentSession();
		try {
			UserDAO dao = new UserDAO();
			
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dao, user);
			
			session.beginTransaction();
			
			session.save(dao);
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		HibernateUtil.closeSession();
	}
	
	public UserDTO login(UserDTO user) {
		Session session = HibernateUtil.currentSession();
		
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO();
		try {
			session.beginTransaction();
			
			dao = (UserDAO) session.createQuery("from UserDAO where email = :email and password = :password")
							.setParameter("email", user.getEmail())
							.setParameter("password", user.getPassword())
							.uniqueResult();
			
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dto, dao);
			
			if (dto.getEmail() != null && !dto.getEmail().equals("")) {
				dto.setHashKey("0987654321");
			}
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();
		return dto;
	}
}
