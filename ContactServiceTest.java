package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ContactServiceTest {
	
	private String firstname1, firstname2, firstname3, lastname1, lastname2, lastname3;
	private String phone1, phone2, phone3, address1, address2, address3;

	@BeforeEach
	void setup() {
		
		firstname1 = "Amy";
		firstname2 = "Bob";
		firstname3 = "Suzanne";
		lastname1 = "Smith";
		lastname2 = "Miller";
		lastname3 = "Peterson";
		phone1 = "1235551234";
		phone2 = "1235557890";
		phone3 = "4565557845";
		address1 = "93 Orchid Street";
		address2 = "555 W. 23rd Ave";
		address3 = "13876 Horseshoe Lane Apt 3";
		
		
		
	}
	
	@Test
	//testing to successfully add contacts with unique ID
	void testAddContactSuccessfully() {
		
		ContactService service = new ContactService();
		
		Contact addedContact1 = service.addContact(firstname1, lastname1, phone1, address1);
		Contact contact1 = service.getContact(addedContact1.getContactId());
		
		assertTrue(contact1.getContactId().equals(addedContact1.getContactId()));
		assertTrue(contact1.getFirstName().equals(firstname1));
		assertTrue(contact1.getLastName().equals(lastname1));
		assertTrue(contact1.getPhone().equals(phone1));
		assertTrue(contact1.getAddress().equals(address1));
		
		Contact addedContact2 = service.addContact(firstname2, lastname2, phone2, address2);
		Contact contact2 = service.getContact(addedContact2.getContactId());
		
		assertTrue(contact2.getContactId().equals(addedContact2.getContactId()));
		assertTrue(contact2.getFirstName().equals(firstname2));
		assertTrue(contact2.getLastName().equals(lastname2));
		assertTrue(contact2.getPhone().equals(phone2));
		assertTrue(contact2.getAddress().equals(address2));
	}

	
	@Test
	void testRemoveContactSuccessful() {
		ContactService service = new ContactService();
		
		Contact addedContact1 = service.addContact(firstname1, lastname1, phone1, address1);
		Contact addedContact2 = service.addContact(firstname2, lastname2, phone2, address2);
		Contact addedContact3 = service.addContact(firstname3, lastname3, phone3, address3);
		
		assertTrue(service.deleteContact(addedContact1.getContactId()));
		assertTrue(service.deleteContact(addedContact3.getContactId()));
		
		
		Contact contact1 = service.getContact(addedContact2.getContactId());
		assertTrue(contact1.getContactId().equals(addedContact2.getContactId()));
		assertTrue(contact1.getFirstName().equals(firstname2));
		assertTrue(contact1.getLastName().equals(lastname2));
		assertTrue(contact1.getPhone().equals(phone2));
		assertTrue(contact1.getAddress().equals(address2));
		
	}
	
	@Test
	void testUpdateContactSuccessful() {
		ContactService service = new ContactService();
		
		Contact addedContact1 = service.addContact(firstname1, lastname1, phone1, address1);
		service.updateContact(addedContact1.getContactId(), firstname2, lastname2, phone2, address2);
		
		Contact contact1 = service.getContact(addedContact1.getContactId());
		
		assertTrue(contact1.getFirstName().equals(firstname2));
		assertTrue(contact1.getLastName().equals(lastname2));
		assertTrue(contact1.getPhone().equals(phone2));
		assertTrue(contact1.getAddress().equals(address2));
		
	}
	
	
	 
	@Test 
	void testAddContactForExceptionUse() {
		ContactService service = new ContactService();
		
		service.addContact(firstname1, lastname1, phone1, address1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getContact("2"); //contact with ID 2 should not exist yet	
		});
	}
	
	@Test
	void testDeleteContactForExceptionUse() {
		ContactService service = new ContactService();
		service.addContact(firstname1, lastname1, phone1, address1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("2"); //contact with ID 2 should not exist yet, so can't delete	
		});
	}
	

}
