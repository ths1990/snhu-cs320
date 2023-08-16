package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import appointment.Appointment;


class AppointmentTest {
	
	protected LocalDate testDate, pastDate, noDate;
	protected String testDesc, longDesc, noDesc;

	@BeforeEach
	void setUp(){
		testDate = LocalDate.of(2023, 12, 31);
		pastDate = LocalDate.of(2020,1,1);
		noDate = null;
		testDesc = "This is a description.";
		longDesc = "dnojuzuhcobxuuizvonkvewtmbinkknpeorkxrplwybicctaggq";
		noDesc = null;
		
	}

	@Test
	@DisplayName("Appointement Class Creation Test")
	void appointmentTest() {
		Appointment appointment = new Appointment(testDate, testDesc);
		assertTrue(appointment.getAppointmentDate().equals(testDate));
		assertTrue(appointment.getAppointmentDesc().equals(testDesc));
		System.out.println(appointment.getAppointmentId()+": "+ appointment.getAppointmentDate()+ " | "+appointment.getAppointmentDesc());
		
	}
	
	@Test
	@DisplayName("Appointment ID Length Test")
	void appoinmentIdLength() {
		Appointment appointment = new Appointment(testDate, testDesc);
		System.out.println(appointment.getAppointmentId());
		if(appointment.getAppointmentId().length() > 10) {
			fail("ID length too long.");
		}
	}
	
	@Test
	@DisplayName("Appointment ID Length Test")
	void appoinmentNullId() {
		Appointment appointment = new Appointment(testDate, testDesc);
		System.out.println(appointment.getAppointmentId());
		if(appointment.getAppointmentId() == null) {
			fail("ID is null");
		}
	}
	
	@Test
	@DisplayName("Task ID must be unique")
	void uniqueTaskId() {
		Appointment appt1 = new Appointment(testDate, testDesc);
		Appointment appt2 = new Appointment(testDate, testDesc);
		Appointment appt3 = new Appointment(testDate, testDesc);
		
		String id1 = appt1.getAppointmentId();
		String id2 = appt2.getAppointmentId();
		String id3 = appt3.getAppointmentId();
		
		System.out.println("1: "+ id1 +" 2: "+ id2 +" 3: " + id3);
		
		assertNotEquals(id1, id2, "IDs are not unique");
		assertNotEquals(id2, id3, "IDs are not unique");
		assertNotEquals(id1, id3, "IDs are not unique");
	}
	
	@Test
	@DisplayName("Date must not be null")
	void nullDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Appointment(noDate, testDesc);});
	}
	
	@Test
	@DisplayName("Date must not be in the past")
	void pastDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Appointment(pastDate, testDesc);});
	}
	
	@Test
	@DisplayName("Description must not be null")
	void nullDesc() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Appointment(testDate, noDesc);});
	}
	
	@Test
	@DisplayName("Description must not be greater than 50 characters.")
	void longDesc() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Appointment(testDate, longDesc);});
	}

}
