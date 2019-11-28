package com.mihaimadan.dermato.dao;

import java.time.LocalDate;
import java.util.List;

import com.mihaimadan.dermato.entity.Appointment;

public interface DermatoDAO {
	
	public List<Appointment> getAppointments();
	
	public List<Appointment> getAppointments(LocalDate date);
	
	public List<Appointment> findBySSN(String ssn);
	
	

}
