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

import com.mocatto.dto.AppointmentDTO;

@Entity
@Table( name = "APPOINTMENT") 
public class AppointmentDAO {

	private Integer id;
	private String email;
	private String eventName;
	private Date appointmentDate;
	private String Location;
	private Integer minutesBefore;
	private Integer petId;

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
	
	@Column(name = "EMAIL", columnDefinition="TEXT")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "EVENT_NAME", columnDefinition="TEXT")
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	@Column(name = "APPOINTMENT_DATE", columnDefinition="DATE")
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	@Column(name = "LOCATION", columnDefinition="TEXT")
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	@Column(name = "MINUTES_BEFORE", columnDefinition="NUMERIC")
	public Integer getMinutesBefore() {
		return minutesBefore;
	}
	public void setMinutesBefore(Integer minutesBefore) {
		this.minutesBefore = minutesBefore;
	}
	
	@Column(name = "PET_ID", columnDefinition="NUMERIC")
	public Integer getPetId() {
		return petId;
	}
	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	public void createAppointment(AppointmentDTO appointment) {
		Session session = HibernateUtil.currentSession();
		
		try {
			AppointmentDAO dao = new AppointmentDAO();
			
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			BeanUtils.copyProperties(dao, appointment);
			
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
	}
	
  public List<AppointmentDTO> getAppointmentsbyEmail(String email) {
	  	 Session session = HibernateUtil.currentSession();
		
	  	  List<AppointmentDTO> appointmentList = new ArrayList<AppointmentDTO>();
		
		try {
			session.beginTransaction();
			
			List<AppointmentDAO> daoList = (List<AppointmentDAO>) session.createQuery("from AppointmentDAO where email = :email").setParameter("email", email).list();
			for (AppointmentDAO dao : daoList) {
				AppointmentDTO dto = new AppointmentDTO();
				BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
				BeanUtils.copyProperties(dto, dao);
	      
				appointmentList.add(dto);
			}
			
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
		} 
		
		HibernateUtil.closeSession();
		return appointmentList;
	}
}
