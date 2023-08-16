package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.AppointmentService;

class AppointmentServiceTest {
	protected LocalDate testDate, pastDate, noDate;
	protected String testDesc, longDesc, noDesc, idMissMatch;
	@BeforeEach
	void setUp() {
		testDate = LocalDate.of(2023, 12, 31);
		pastDate = LocalDate.of(2020,1,1);
		noDate = null;
		testDesc = "This is a description.";
		longDesc = "dnojuzuhcobxuuizvonkvewtmbinkknpeorkxrplwybicctaggq";
		noDesc = null;
		idMissMatch = "1";
	}

	@Test
	@DisplayName("Test the Appointment Service can create an Appointment")
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(testDate, testDesc);
		service.displayAppointments();
		assertNotNull(service.getAppointmentMap());
	}
	
	@Test
	@DisplayName("Test that Appointment Service can create multiple Appointments with no collisions")
	void multipleAppointments() {
		AppointmentService service  = new AppointmentService();
		
		for(int i = 0; i < 10; i++) {
			service.addAppointment(testDate, testDesc);
		}
		System.out.println(service.getAppointmentMap().size() + " appointments created.");
		if(service.getAppointmentMap().size() < 10) {
			fail ("Due to duplicate IDs, not all appointments were created.");
		}
	}
	
	@Test
	@DisplayName("Test that duplicate IDs will not be saved to the appointmentMap.")
	void duplicateId() {
		AppointmentService service = new AppointmentService();
		Appointment appointment = new Appointment(testDate,testDesc);
		service.duplicateIdCheck(appointment.getAppointmentId(), appointment);
		service.displayAppointments();
		Appointment appointment2 = new Appointment(testDate,testDesc);
		service.duplicateIdCheck(appointment.getAppointmentId(), appointment2);
		service.displayAppointments();
		assertTrue(service.getAppointmentMap().size() == 1);
	}
	
	@Test
	@DisplayName("Test Deleting Appointments")
	void deleteAppointmentTest() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(testDate, testDesc);
		service.displayAppointments();
		for(String i: service.getAppointmentMap().keySet()) {
			service.deleteAppointment(service.appointmentMap.get(i).getAppointmentId());
		}
		assertTrue(service.getAppointmentMap().isEmpty());
	}
	
	@Test
	@DisplayName("Test ID cannot be found")
	void idNotFoundTest() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(testDate, testDesc);
		service.displayAppointments();
		service.deleteAppointment(idMissMatch);
	}

}
