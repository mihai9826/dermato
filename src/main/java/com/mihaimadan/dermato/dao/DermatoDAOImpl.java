package com.mihaimadan.dermato.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mihaimadan.dermato.entity.Appointment;

@Repository
public class DermatoDAOImpl implements DermatoDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Appointment> getAppointments() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Appointment> theQuery = 
				currentSession.createQuery("from Appointment", Appointment.class);
		
		return theQuery.getResultList();
	}
	
	@Override
	public List<Appointment> getAppointments(LocalDate date) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Appointment> theQuery = 
				currentSession.createQuery("from Appointment where date=:date", Appointment.class);
		
		theQuery.setParameter("date", date);
		
		return theQuery.getResultList();
		
	}

	
	

	@Override
	public List<Appointment> findBySSN(String ssn) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Appointment> theQuery = 
				currentSession.createQuery("from Appointment where ssn=:ssnId",
						Appointment.class);
		
		theQuery.setParameter("ssnId", ssn);
		
		return theQuery.getResultList();
	}

}
