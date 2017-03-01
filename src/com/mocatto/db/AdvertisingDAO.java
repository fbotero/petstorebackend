package com.mocatto.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.hibernate.Session;
import org.hibernate.annotations.GenericGenerator;

import com.mocatto.dto.AdvertisingDTO;

@Entity
@Table(name = "ADVERTISING")
public class AdvertisingDAO {

	private Integer id;
	private String name;
	private Integer timesToShow;
	private Integer timesShowed;
	private String image;
	private Boolean active;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", columnDefinition = "TEXT")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TIMES_TO_SHOW", columnDefinition = "NUMERIC")
	public Integer getTimesToShow() {
		return timesToShow;
	}

	public void setTimesToShow(Integer timesToShow) {
		this.timesToShow = timesToShow;
	}

	@Column(name = "TIMES_SHOWED", columnDefinition = "NUMERIC")
	public Integer getTimesShowed() {
		return timesShowed;
	}

	public void setTimesShowed(Integer timesShowed) {
		this.timesShowed = timesShowed;
	}

	@Column(name = "IMAGE", columnDefinition = "TEXT")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "ACTIVE", columnDefinition = "BOOLEAN")
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public AdvertisingDTO getActiveAdvertising(boolean active) {
		Session session = HibernateUtil.currentSession();
		AdvertisingDTO dto = new AdvertisingDTO();

		try {
			session.beginTransaction();

			AdvertisingDAO dao = (AdvertisingDAO) session.createQuery("from AdvertisingDAO where active = :active")
					.setParameter("active", active).uniqueResult();

			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dto, dao);

			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		}

		HibernateUtil.closeSession();
		return dto;
	}
	
	public int save(AdvertisingDTO dto) {
		Session session = HibernateUtil.currentSession();
		
		AdvertisingDAO dao = new AdvertisingDAO();
		try {
			
			
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dao, dto);
			
			if (dto.getId() == null || dto.getId() == 0) {
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

}
