package appointment;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Appointment {
	//Declared constant for Current Date
	private static final LocalDate TODAY = LocalDate.now();
	//Declared constants for character limits
	private static final int ID_MAX = 10;
	private static final int DESC_MAX = 50;
	
	private static AtomicInteger createId = new AtomicInteger(1);
	
	//Variable for Appointment ID. Set to private final to prevent updating.
	private final String appointmentId;
	//Appointment variables
	private LocalDate appointmentDate;
	private String appointmentDesc;
	
	public Appointment(LocalDate appointmentDate, String appointmentDesc) {
		this.appointmentId = "AP"+String.format("%08d", createId.getAndIncrement());
		
		//validate ID method
		dataValidator(appointmentId,ID_MAX);
		//validate Date method
		checkDate(appointmentDate);
		//validate Desc method
		dataValidator(appointmentDesc,DESC_MAX);
		
		this.appointmentDate = appointmentDate;
		this.appointmentDesc = appointmentDesc;
		
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDesc() {
		return appointmentDesc;
	}
	
	public void setAppointmentDate(LocalDate appointmentDate) {
		checkDate(appointmentDate);
		this.appointmentDate = appointmentDate;
	}
	
	public void setAppointmentDesc (String appointmentDesc) {
		dataValidator(appointmentDesc, DESC_MAX);
		this.appointmentDesc = appointmentDesc;
	}
	
	private void dataValidator(String input, int charCriteria) {
		if(input == null){
			throw new IllegalArgumentException("Invalid. Data cannot be null.");
		}
		if(input.length()>charCriteria) {
			throw new IllegalArgumentException("Invalid. Data is " + input.length() +" characters and cannot exceed " + charCriteria + " characters.");
		}
		}
	
	private void checkDate(LocalDate inputDate) {
		if(inputDate == null) {
			throw new IllegalArgumentException("Invalid. Date cannot be njull");
		}
		
		if(inputDate.isBefore(TODAY)) {
			throw new IllegalArgumentException("Invalid. Date selected: " + inputDate + " cannot occure before: " + TODAY);
		}
	}
	
	

}
