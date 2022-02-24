package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentServiceTest {
	
	private String description1, description2, description3;
	private Date date1, date2, date3;
	
	//used to remove deprecation warnings from Java. Date class is out-dated. Would be better to use Calendar or LocalTime class
	@SuppressWarnings("deprecation")
	
	@BeforeEach
	void setup() {
		
		date1 = new Date(2023, 0, 1);
		date2 = new Date(2023, 1, 5);
		date3 = new Date (2023, 5, 15);
		description1 = "appointment description up to 50 chars";
		description2 = "second appointment description";
		description3 = "third appointment description";
		
	}

	//testing the ability to add an appointment with unique ID
	@Test
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		
		Appointment addedAppointment1 = service.addAppointment(date1, description1);
		Appointment addedAppointment2 = service.addAppointment(date2, description2);
		
		Appointment appointment1 = service.getAppointment(addedAppointment1.getAppointmentId());
		
		assertTrue(appointment1.getAppointmentId().equals(addedAppointment1.getAppointmentId()));
		assertTrue(appointment1.getAppointmentDate().equals(date1));
		assertTrue(appointment1.getAppointmentDescription().equals(description1));
		
		Appointment appointment2 = service.getAppointment(addedAppointment2.getAppointmentId());
		
		assertTrue(appointment2.getAppointmentId().equals(addedAppointment2.getAppointmentId()));
		assertTrue(appointment2.getAppointmentDate().equals(date2));
		assertTrue(appointment2.getAppointmentDescription().equals(description2));
	}
	
	//Testing to make sure some appointments can be deleted while others are not
	@Test
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		
		Appointment addedAppointment1 = service.addAppointment(date1, description1);
		Appointment addedAppointment2 = service.addAppointment(date2, description2);
		Appointment addedAppointment3 = service.addAppointment(date3, description3);
		
		assertTrue(service.deleteAppointment(addedAppointment1.getAppointmentId()));
		assertTrue(service.deleteAppointment(addedAppointment3.getAppointmentId()));
		
		Appointment appointment1 = service.getAppointment(addedAppointment2.getAppointmentId());
		assertTrue(appointment1.getAppointmentId().equals(addedAppointment2.getAppointmentId()));
		assertTrue(appointment1.getAppointmentDate().equals(date2));
		assertTrue(appointment1.getAppointmentDescription().equals(description2));

	}
	
	@Test
	void testGetAppointmentForExceptionUse() {
		
		AppointmentService service = new AppointmentService();
		Appointment addedAppointment1 = service.addAppointment(date1, description1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointment("2"); //appointment with ID 2 should not exist yet	
		});
	}
	
	@Test
	void testDeleteAppointmentForExceptionUse() {
		
		AppointmentService service = new AppointmentService();
		Appointment addedAppointment1 = service.addAppointment(date1, description1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment("2"); //contact with ID 2 should not exist yet, so can't delete	
		});
	}
	
	
}