package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentTest {
	
private String id, description, tooLongId, tooLongDescription;
private Date date, dateInPast;
	
	//used to remove deprecation warnings from Java. Date class is out-dated. Would be better to use Calendar or LocalTime class
	@SuppressWarnings("deprecation") 
	
	@BeforeEach
	void setup() {
		id = "apptID1234";
		date = new Date(123, 0, 1); //java.Date year starts at 1900 so 123 means 2023
		description = "appointment description up to 50 chars";
		tooLongId = "apptID12345";
		dateInPast = new Date (110, 0, 1); //java.Date year starts at 1900 so 110 means 2010
		tooLongDescription = "appointment description is more than 50 characters long which violates the requirements of the appointment description";
		
	}

	@Test
	void testAppointment() {
		Appointment appointment = new Appointment(id, date, description);
		
		assertTrue(appointment.getAppointmentId().equals(id));
		assertTrue(appointment.getAppointmentDate().equals(date));
		assertTrue(appointment.getAppointmentDescription().equals(description));
	}
	
	@Test
	void testApptIdExceptionsUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(tooLongId, date, description);
			new Appointment("", date, description);
		});
	}
	
	@Test
	void testApptDateExceptionsUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, dateInPast, description);
			new Appointment(id, null, description);
		});
	}
	
	@Test
	void testApptDescriptionExceptionsUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, tooLongDescription);
			new Appointment(id, date, "");
		});
	}

}
