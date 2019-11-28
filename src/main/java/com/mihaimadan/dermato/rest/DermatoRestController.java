package com.mihaimadan.dermato.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mihaimadan.dermato.entity.Appointments;
import com.mihaimadan.dermato.service.DermatoService;

@RestController
public class DermatoRestController {
	
	@Autowired
	private DermatoService dermatoService;
	
	@GetMapping("/appointments")
	public Appointments getAllAppointments(@RequestParam(required=false) String date) {
		
		if(date != null) {
			Appointments appointments = new Appointments();
			
			appointments.setPatientAppointments(dermatoService.getAppointments(date));
			
			return appointments;
		}
		
		Appointments appointments = new Appointments();
		
		appointments.setPatientAppointments(dermatoService.getAppointments());
		
		return appointments;
	}
	
	@GetMapping("/appointments/{appointmentSSN}")
	public Appointments getAppointmentsBySSN(@PathVariable String appointmentSSN) {
		
		Appointments appoints = new Appointments();
		
		appoints.setPatientAppointments(dermatoService.findBySSN(appointmentSSN));
		
		return appoints;
		
	}

	

}
