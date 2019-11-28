package com.mihaimadan.dermato.service;

import java.util.List;

import com.mihaimadan.dermato.entity.Appointment;

public interface DermatoService {
	
	public List<Appointment> findBySSN(String ssn);
	
	public List<Appointment> getAppointments();
	
	public List<Appointment> getAppointments(String date);

}
