package contact;

import java.util.ArrayList;
import java.util.Iterator;

public class ContactService {
	
	int Id = 0;
	
	//create contactList array
	private ArrayList<Contact> contactList = new ArrayList<>();
	
	
	public Contact getContact(String ID) {
		
		Iterator<Contact> itr = contactList.iterator();
		
		while (itr.hasNext()) {
			Contact contact = itr.next();
			if (contact.getContactId().equals(ID)) {
					
				return contact;
							
			} 
		}
		throw new IllegalArgumentException("no such contact");
	}

	
	//adds a contact to the contactList array
	public Contact addContact(String firstName, String lastName, String Phone, String Address) {

		Id++; //increment ID to make a unique ID
		
		 //convert integer to string for ArrayList
		String contactId = Integer.toString(Id);
		//create contact object
		Contact contact = new Contact(contactId, firstName, lastName, Phone, Address);
		//add contact to list
		contactList.add(contact);
		
		return contact;
		
	}
	
	//deletes a contact from the contactLast array
	public boolean deleteContact(String ID) {
		
		Iterator<Contact> itr = contactList.iterator();
		
		int idx = 0;
		
		while (itr.hasNext()) {
			Contact contact = itr.next();
			if (!contact.getContactId().equals(ID)) {
				
				idx++;
			} else {
				contactList.remove(idx);
				return true;
			}
		}
		throw new IllegalArgumentException("no such contact");
	}
	
	//updates an existing contact firstname, lastname, phone, and address
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		
		Contact contact = getContact(contactId);
				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setPhone(phone);
				contact.setAddress(address);
		}
		
		
		
		
	}
	
	
	

