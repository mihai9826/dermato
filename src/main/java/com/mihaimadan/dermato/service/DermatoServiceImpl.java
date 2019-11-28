package com.mihaimadan.dermato.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mihaimadan.dermato.dao.DermatoDAO;
import com.mihaimadan.dermato.entity.Appointment;



@Service
public class DermatoServiceImpl implements DermatoService {
	
	@Autowired
	private DermatoDAO dermatoDAO;
	
	Logger logger = LoggerFactory.getLogger(DermatoServiceImpl.class);
	
	@Override
	@Transactional
	public List<Appointment> getAppointments() {
		
		return dermatoDAO.getAppointments();
	}
	
	@Override
	@Transactional
	public List<Appointment> getAppointments(String date) {

		
		String[] splitted = date.split("-");
		
		logger.info("splitted date" + splitted[0] + " " + splitted[1]);
		
		LocalDate theDate = LocalDate.parse(date);
		
		return dermatoDAO.getAppointments(theDate);
	}

	@Override
	@Transactional
	public List<Appointment> findBySSN(String ssn) {
		
		return dermatoDAO.findBySSN(ssn);
	}

	

}
