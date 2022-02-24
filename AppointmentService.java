package contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

public class AppointmentService {
	
	int Id = 0;
	
	//create appointmentList array
	private ArrayList<Appointment> appointmentList = new ArrayList<>();
	
	//adds an appointment to the appointmentList array
	public Appointment addAppointment(Date appointmentDate, String appointmentDescription) {

		Id++; //increment ID to make a unique ID
			
		//convert integer to string for ArrayList
		String appointmentId = Integer.toString(Id);
		//create appointment object
		Appointment appointment = new Appointment(appointmentId, appointmentDate, appointmentDescription);
		//add appointment to list
		appointmentList.add(appointment);
			
		return appointment;
			
	}
	
	public Appointment getAppointment(String Id) {
		
		Iterator<Appointment> itr = appointmentList.iterator();
		
		//iterate through appointment list and return appointment, if found, or throw exception
		while (itr.hasNext()) {
			Appointment appointment = itr.next();
			if (appointment.getAppointmentId().equals(Id)) {
				
				return appointment;
			} 
		}
		throw new IllegalArgumentException("no such appointment");
	}
	
	public boolean deleteAppointment(String Id) {
		
		Iterator<Appointment> itr = appointmentList.iterator();
		
		int idx = 0; //index to hold appointment position on list
		
		//iterates through list and deletes appointment if matching ID is found, else throws exception
		while (itr.hasNext()) {
			Appointment appointment = itr.next();
			if (!appointment.getAppointmentId().equals(Id)) {
				idx++;
				
			} else {
				
				appointmentList.remove(idx);
				return true;
			}
		}
		throw new IllegalArgumentException("can't delete appointment");
	}
		

}
