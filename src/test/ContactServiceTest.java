package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import contact.Contact;
import contact.ContactService;


class ContactServiceTest {
		protected String  testFirstName,  testLastName,  testPhoneNum,  testAddress, updateFirstName,
		updateLastName, updatePhoneNum, updateAddress;
		
		protected String noFirstName,  longFirstName,  noLastName, longLastName,
		 noPhoneNum,  shortPhoneNum,  longPhoneNum,  invalidPhoneNum,  noAddress,  longAddress, missingId, grabId;
		
	@BeforeEach
	void setUp() {
		testFirstName = "Clive";
		testLastName = "Rosfield";
		testPhoneNum = "5555555555";
		testAddress = "123 Hideaway Ln";
		updateFirstName= "Cid";
		updateLastName = "Telamon";
		updatePhoneNum = "1111111111";
		updateAddress = "523 Rosalith Rd";
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
		missingId = "1";
		grabId = null;
	}
	

	@Test
	@DisplayName("Contacts can be added")
	void testAddContact() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		service.displayContacts();
		assertNotNull(service.getContactMap());
	}
	
	@Test
	@DisplayName ("Multiple contacts can be created, each with a unique ID")
	void addMultiContact() {
		ContactService service = new ContactService();
		for(int i = 0; i < 10; i++) {
			service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		}
		System.out.println(service.getContactMap().size() + " contacts created.");
		if(service.getContactMap().size() < 10) {
			fail ("Due to duplicate IDs, not all contacts were created.");
		}
	}
	
	@Test
	@DisplayName("Duplicate ID Found")
	void duplicateId() {
		ContactService service = new ContactService();
		Contact contact =  new Contact (testFirstName, testLastName, testPhoneNum, testAddress);
		service.displayContacts();
		Contact contact2 = new Contact (testFirstName, testLastName, testPhoneNum, testAddress);
		service.duplicateIdCheck(contact.getContactId(), contact2);
		service.displayContacts();
		assertTrue(service.getContactMap().size() == 1);
	}
	
	@Test
	@DisplayName ("Using the contactId, a contact can be deleted.")
	void testDeleteContact() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		service.displayContacts();
		for(String i: service.getContactMap().keySet()) {
			service.deleteContact(service.contactMap.get(i).getContactId());
		}
		assertTrue(service.getContactMap().isEmpty());
		
	}
	

	

	@Test
	@DisplayName("Using the contact Id, First Name can be updated.")
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		service.displayContacts();
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		
		service.updateFirstName(updateFirstName, grabId);
		service.displayContacts();
		assertEquals(updateFirstName,service.getContactMap().get(grabId).getFirstName(), "The first name was not updated.");
		
	}
	

	
	
	@Test
	@DisplayName("First name cannot be updated as a null value")
	void testUpdateNullFirstName() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{service.updateFirstName(noFirstName,service.getContactMap().get(grabId).getContactId());});
		
	}
	
	@Test
	@DisplayName("First name cannot be updated with more than 10 characters")
	void testUpdateLongFirstName() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{service.updateFirstName(longFirstName,service.getContactMap().get(grabId).getContactId());});
		
	}

	@Test
	@DisplayName("Using the contact Id, Last Name can be updated.")
	void testUpdateLastName() {
			ContactService service = new ContactService();
			service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
			for(String i: service.getContactMap().keySet()) {
				 grabId = service.contactMap.get(i).getContactId();
			}
			service.updateLastName(updateLastName, grabId);
			service.displayContacts();
			assertEquals(updateLastName,service.getContactMap().get(grabId).getLastName(), "The last name was not updated.");
	}
	
	
	@Test
	@DisplayName("Last name cannot be updated as a null value")
	void testUpdateNullLastName() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{service.updateLastName(noLastName,service.getContactMap().get(grabId).getContactId());});
		
	}
	
	@Test
	@DisplayName("Last name cannot be updated with more than 10 characters")
	void testUpdateLongLastName() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{service.updateLastName(longLastName,service.getContactMap().get(grabId).getContactId());});
	}

	@Test
	@DisplayName("Using the contact ID, phone number can be updated")
	void testUpdateNumber() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		service.updateNumber(updatePhoneNum, grabId);
		service.displayContacts();
		assertEquals(updatePhoneNum,service.getContactMap().get(grabId).getPhoneNum(), "The phone number was not updated.");
		
	}
	

	
	
	@Test
	@DisplayName("Phone number cannot be updated to null")
	void testUpdateNullNumber() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{service.updateNumber(noPhoneNum,service.getContactMap().get(grabId).getContactId());});
	}
	
	@Test
	@DisplayName("Phone number cannot be updated with more than 10 characters")
	void testUpdateLongNumber() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{service.updateNumber(longPhoneNum,service.getContactMap().get(grabId).getContactId());});
	}
	
	@Test
	@DisplayName("Phone number cannot be updated with less than 10 characters")
	void testUpdateShortNumber() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{service.updateNumber(shortPhoneNum,service.getContactMap().get(grabId).getContactId());});
	}
	
	@Test
	@DisplayName("Phone number cannot be updated to include characters other than numbers")
	void testUpdateInvalidNumber() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{service.updateNumber(invalidPhoneNum,service.getContactMap().get(grabId).getContactId());});
	}

	@Test
	@DisplayName("Using contact ID, address can be updated")
	void testUpdateAddress() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		service.updateAddress(updateAddress, grabId);
		service.displayContacts();
		assertEquals(updateAddress,service.getContactMap().get(grabId).getAddress(), "The address was not updated.");
	}
	

	@Test
	@DisplayName("Address cannot be updated to null")
	void testUpdateNullAddress() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{service.updateAddress(noAddress,service.getContactMap().get(grabId).getContactId());});
	}
	
	@Test
	@DisplayName("Address cannot be updated to with more than 30 characters")
	void testUpdateLongAddress() {
		ContactService service = new ContactService();
		service.addContact(testFirstName,testLastName,testPhoneNum,testAddress );
		for(String i: service.getContactMap().keySet()) {
			 grabId = service.contactMap.get(i).getContactId();
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{service.updateAddress(longAddress,service.getContactMap().get(grabId).getContactId());});
	}
	

}
