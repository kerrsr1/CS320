package contact;

public class Contact {
	
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Contact constructor
	public Contact (String contactId, String firstName, String lastName, String phone, String address) {
		
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
		
	}
	
	public void setContactId(String contactId) {
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("invalid contact ID");
		}
		this.contactId = contactId;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("invalid first name");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("invalid last name");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("invalid phone number");
		}
		this.phone = phone;
	}
		
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("invalid address");
		}
		this.address = address;
	}
		

	//getters
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
}
