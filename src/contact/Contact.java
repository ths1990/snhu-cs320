/********************
 * Name: Ty Simpson
 * Course: CS-320
 * Date: 7/14/2023
 ********************/

package contact;

import java.util.concurrent.atomic.AtomicInteger;


public class Contact {
	//Length parameter constants
	private final static int MAX_LENGTH = 10;
	private final static int MAX_ADDRESS = 30;
	private final static String REGEX = "[0-9]+";
	private static AtomicInteger createId = new AtomicInteger(1);
	//Contact variables
	private final String contactId; //Set the private final to prevent ID from being updated
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;


	
	
	//Constructor
	public Contact(String  firstName, String lastName, String phoneNum, String address) 
	{
		this.contactId = "CT"+String.format("%08d", createId.getAndIncrement()); //Concatenates CT to the ID to note that the ID is a Contact ID
		
	
			dataValidator(this.contactId, MAX_LENGTH); //Calls dataValidator method, passing contactId and MAX_LENGTH as parameters. 
		
			dataValidator(firstName, MAX_LENGTH); //Calls dataValidator method, passing firstName and MAX_LENGTH as parameters.
			
			dataValidator(lastName, MAX_LENGTH); //Calls dataValidator method, passing lastName and MAX_LENGTH as parameters.
		
			phoneValidator(phoneNum); //Calls phoneValidator method, passing phoneNum as a parameter.

			dataValidator(address, MAX_ADDRESS); //Calls dataValidator method, passing address and MAX_ADDRESS as parameters.


		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.address = address;
		

	}
	
	//Getters
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public String getAddress() {
		return address;
	}
	
	//Setters

	
	public void setFirstName(String firstName) {
		dataValidator(firstName, MAX_LENGTH);
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		dataValidator(lastName, MAX_LENGTH);
		this.lastName = lastName;
		
	}
	
	public void setPhoneNum(String phoneNum) {
		
		phoneValidator(phoneNum);
		this.phoneNum = phoneNum;
		
	}
	public void setAddress(String address) {
		dataValidator(address, MAX_ADDRESS);
		this.address = address;
		
	}
	
	// Validates data passed through the parameters, checks if input is null and whether the input exceeds 
	// charCriteria. Used to check contactId, firstName, lastName, and address
	
	private void dataValidator(String input, int charCriteria) {
		if(input == null){
			throw new IllegalArgumentException("Invalid. Data cannot be null.");
		}
		if(input.length()>charCriteria) {
			throw new IllegalArgumentException("Invalid. Data is " + input.length() +" characters and cannot exceed " + charCriteria + " characters.");
		}
		}
	
	
	//Validates phoneNum. Checks for null, length, and that the phoneNum only consists of numbers
	private void phoneValidator(String phoneNum) {
		if(phoneNum == null) {
			throw new IllegalArgumentException("Invalid. Data cannot be null.");
		}
		
		if(phoneNum.length()!=MAX_LENGTH) {
			throw new IllegalArgumentException("Invalid. Phone number must be exactly " + MAX_LENGTH + " digits.");
		}
		if(!phoneNum.matches(REGEX)) {
			throw new IllegalArgumentException("Invalid. Phone number must consist only of digits 0-9.");
		}
	}
	}
