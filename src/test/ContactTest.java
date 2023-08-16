package test;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {
	protected String   testFirstName,  testLastName,  testPhoneNum,  testAddress;
	protected String   noFirstName,  longFirstName,  noLastName, longLastName,
	 noPhoneNum,  shortPhoneNum,  longPhoneNum,  invalidPhoneNum,  noAddress,  longAddress;
	
	@BeforeEach
	void setUp() {
		testFirstName = "Clive";
		testLastName = "Rosfield";
		testPhoneNum = "5555555555";
		testAddress = "123 Hideaway Ln";
		noFirstName = null;
		longFirstName = "Clive Rosefield";
		noLastName = null;
		longLastName = "Rosefield Clive";
		noPhoneNum = null;
		shortPhoneNum = "1234";
		longPhoneNum = "55555555556";
		invalidPhoneNum = "555-555-123";
		noAddress = null;
		longAddress = "A Realm Reborn, Heavensward, Stormblood, Shadowbringers, Endwalker";
	}
	
	@Test
	@DisplayName("Class creation Test")
	void testContact() {
		Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
		assertTrue(contact.getFirstName().equals(testFirstName));
		assertTrue(contact.getLastName().equals(testLastName));
		assertTrue(contact.getPhoneNum().equals(testPhoneNum));
		assertTrue(contact.getAddress().equals(testAddress));
		System.out.println(contact.getContactId());
		}

	@Test
	@DisplayName("Contact ID Cannot be more than 10 characters")
	void testContactId() {
		Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
		System.out.println(contact.getContactId());
		if(contact.getContactId().length() > 10) {
			fail("Contact ID is too long");
		}
		}
	
	@Test
	@DisplayName("Contact ID cannot be null.")
	void nullId() {
		Contact contact = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
		System.out.println(contact.getContactId());
		if(contact.getContactId() == null) {
			fail("Contact ID is null");
		}
		
	}
	
//Contact ID cannot be updated, the contactId variable in the class is set to private final and has no setter method therefore cannot be updated
	
	@Test
	@DisplayName("Contact ID must be unique.")
	void uniqueId() {
		Contact contact1 = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
		Contact contact2 = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
		Contact contact3 = new Contact(testFirstName,testLastName,testPhoneNum,testAddress);
		
		String id1 = contact1.getContactId();
		String id2 = contact2.getContactId();
		String id3 = contact3.getContactId();
		
		System.out.println("1: " + id1 + " 2: " + id2 + " 3: " + id3);
		
		assertNotEquals(id1, id2, "IDs are not unique.");
		assertNotEquals(id2, id3, "IDs are not unique.");
		assertNotEquals(id1, id3, "IDs are not unique.");
	}
	

	
	@Test
	@DisplayName("First name may not be null")
	void nullFirstNameTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact(noFirstName,testLastName,testPhoneNum,testAddress);});
		
	}
	
	@Test
	@DisplayName("First name may not exceed 10 characters")
	void firstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact(longFirstName,testLastName,testPhoneNum,testAddress);});
		
	}
	
	
	@Test
	@DisplayName("Last name may not be null")
	void nullLasstNameTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact(testFirstName,noLastName,testPhoneNum,testAddress);});
		
	}
	
	@Test
	@DisplayName("Last name may not exceed 10 characters")
	void lastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact(testFirstName,longLastName,testPhoneNum,testAddress);});
		
	}
	
	
	@Test
	@DisplayName("Phone number may not be null")
	void nullPhoneTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact(testFirstName,testLastName,noPhoneNum,testAddress);});
		
	}
	
	@Test
	@DisplayName("Phone number may not equal more than 10 characters")
	void phoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact(testFirstName,testLastName,longPhoneNum,testAddress);});
		
	}
	
	@Test
	@DisplayName("Phone number may not equal less than 10 characters")
	void phoneNotLongEnough() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact(testFirstName,testLastName,shortPhoneNum,testAddress);});
		
	}
	
	@Test
	@DisplayName("Phone number may only have numbers 0-9")
	void phoneIllegalCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact(testFirstName,testLastName,invalidPhoneNum,testAddress);});
		
	}
	
	
	@Test
	@DisplayName("Address may not be null")
	void nullAddressTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact(testFirstName,testLastName,testPhoneNum,noAddress);});
		
	}
	
	@Test
	@DisplayName("Address must not exceed 30 characters")
	void addressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact(testFirstName,testLastName,testPhoneNum,longAddress);});
		
	}

}
