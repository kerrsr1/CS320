package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ContactTest {
	
	private String id, firstname, lastname, phone, address;
	private String tooLongId, tooLongFirstName, tooLongLastName, badPhone, tooLongAddress;
	
	@BeforeEach
	void setup() {
		id = "contactID1";
		firstname = "FirstName1";
		lastname = "LastName12";
		phone = "1235551111";
		address = "address Less Than 30 123456789";
		tooLongId = "contactID12";
		tooLongFirstName = "FirstName12";
		tooLongLastName = "LastName123";
		badPhone = "123555111";
		tooLongAddress = "address is too long if over 30 characters long";
	}

	@Test
	//testing to make sure each variable can be added to Contact
	void testContact() {
		Contact contact = new Contact(id, firstname, lastname, phone, address);
		assertTrue(contact.getContactId().equals(id));
		assertTrue(contact.getFirstName().equals(firstname));
		assertTrue(contact.getLastName().equals(lastname));
		assertTrue(contact.getPhone().equals(phone));
		assertTrue(contact.getAddress().equals(address));
	}
	
	//testing for exceptions thrown when too many characters entered and when null value entered
	@Test 
	void testContactIDForExceptionUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(tooLongId, firstname, lastname, phone, address);
			new Contact(null, firstname, lastname, phone, address);
		});
	}
	@Test
	void testFirstNameForExceptionUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, tooLongFirstName, lastname, phone, address);
			new Contact(id, null, lastname, phone, address);
		});
	}
	@Test
	void testLastNameForExceptionUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstname, tooLongLastName, phone, address);
			new Contact(id, firstname, null, phone, address);
		});
	}
	@Test
	void testPhoneForExceptionUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstname, lastname, badPhone, address);
			new Contact(id, firstname, lastname, null, address);
		});
	}
	@Test
	void testAddressForExceptionUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(id, firstname, lastname, phone, tooLongAddress);
			new Contact(id, firstname, lastname, phone, null);
		});
	}

}
