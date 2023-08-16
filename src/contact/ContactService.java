package contact;


import java.util.HashMap;
import java.util.Map;






public class ContactService {
	//Create Array List to Store Contacts
	public Map<String,Contact> contactMap = new HashMap<String,Contact>();
	
	//Method to add contact to list
	public void addContact(String firstName, String lastName, String phoneNum, String address) {
		
		Contact contact = new Contact(firstName,lastName,phoneNum,address);
		//Grab contact id from newly created instance
		String id = contact.getContactId();
		//Iterate through contactList to check for duplicate IDs
		duplicateIdCheck(id, contact);
		
	}
	
	//Display a list of contacts for testing purposes
	public void displayContacts() {
		for (String i : contactMap.keySet()) {
			  System.out.println("Contact Id: " + contactMap.get(i).getContactId());
			  System.out.println("First Name: " + contactMap.get(i).getFirstName());
			  System.out.println("Last Name: " + contactMap.get(i).getLastName());
			  System.out.println("Phone: " + contactMap.get(i).getPhoneNum());
			  System.out.println("Address: " + contactMap.get(i).getAddress());
			}
	}
	
	
	//Method to delete contacts
	public void deleteContact (String contactId) {
		if(contactMap.containsKey(contactId)) {
			contactMap.remove(contactId);
		} else {
			System.out.println("Contact Id: " + contactId + " cannot be found.");
		}
	}
	
	//Method to update first name
	public void updateFirstName (String updatedFirstName, String contactId) {
		if(contactMap.containsKey(contactId)) {
			contactMap.get(contactId).setFirstName(updatedFirstName);
		} else {
			System.out.println("Contact Id: " + contactId + " cannot be found.");
		}
			}
		
	
		//Method to update last name
		public void updateLastName (String updatedLastName, String contactId) {
			if(contactMap.containsKey(contactId)) {
				contactMap.get(contactId).setLastName(updatedLastName);
			} else {
				System.out.println("Contact Id: " + contactId + " cannot be found.");
			}
			
		}
			//Method to update phone number
			public void updateNumber (String updatedNumber, String contactId) {
				if(contactMap.containsKey(contactId)) {
					contactMap.get(contactId).setPhoneNum(updatedNumber);
				} else {
					System.out.println("Contact Id: " + contactId + " cannot be found.");
				}
				
			}
				//Method to update address
				public void updateAddress (String updatedAddress, String contactId) {
					if(contactMap.containsKey(contactId)) {
						contactMap.get(contactId).setAddress(updatedAddress);
					} else {
						System.out.println("Contact Id: " + contactId + " cannot be found.");
					}
				}

	

			//Method to return ContactMap
				public Map<String, Contact> getContactMap(){
					return contactMap;
				}
				
				public void duplicateIdCheck(String instanceId, Contact object) {
					 
					 if(contactMap.containsKey(instanceId)) {
						 System.out.println("Contact ID already exists.");
						 return;
					 }
					 else {
						 contactMap.put(instanceId, object);
					 }
				}

				}
