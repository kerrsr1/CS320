package contact;

import java.util.Date; //used to get current date

public class Appointment {
	
	private String appointmentId;
	private Date appointmentDate;
	private String appointmentDescription;
	
	public Appointment (String appointmentId, Date appointmentDate, String appointmentDescription) {
		
		setAppointmentId(appointmentId);
		setAppointmentDate(appointmentDate);
		setAppointmentDescription(appointmentDescription);
		
	}
	
	public void setAppointmentId(String appointmentId) {
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("invalid appointment ID");
		}
		
		this.appointmentId = appointmentId;
	}
	
	public void setAppointmentDate(Date appointmentDate) {
		//Constructor for date object
		Date currentDate = new Date();
				
				
		if (appointmentDate == null || appointmentDate.before(currentDate)) {
			throw new IllegalArgumentException("Date cannot be null or in the past");
		}
		this.appointmentDate = appointmentDate;
	}
	
	public void setAppointmentDescription(String appointmentDescription) {
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("invalid appointment description");
		}
		
		this.appointmentDescription = appointmentDescription;
	}
		
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	

}
