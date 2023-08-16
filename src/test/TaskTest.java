package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import task.Task;

class TaskTest {

	protected String testName, testDesc;
	protected String noName, longName, noDesc, longDesc;
	
	@BeforeEach
	void setUp() {
		testName = "Test Task";
		testDesc = "This is a test.";
		noName = null;
		longName = "pyZOODNTOBVdBvsKOuTSV";
		noDesc = null;
		longDesc = "dnojuzuhcobxuuizvonkvewtmbinkknpeorkxrplwybicctaggq";
	}

	@Test
	@DisplayName("Test class creation")
	void testTask() {
		Task task = new Task (testName, testDesc);
		assertTrue(task.getTaskName().equals(testName));
		assertTrue(task.getTaskDescription().equals(testDesc));
		System.out.println(task.getTaskId());
	}
	
	@Test
	@DisplayName("Task ID Cannot be more than 10 characters")
	void testTaskIdLength() {
		Task task = new Task(testName, testDesc);
		System.out.println(task.getTaskId());
		if(task.getTaskId().length() > 10) {
			fail("Task ID is too long");
		}
		}
	
	@Test
	@DisplayName("Task ID cannot be null.")
	void nullId() {
		Task task = new Task(testName, testDesc);
		System.out.println(task.getTaskId());
		if(task.getTaskId() == null) {
			fail("Task ID is null");
		}
		
	}
	
	@Test
	@DisplayName("Task ID must be unique")
	void uniqueTaskId() {
		Task task1 = new Task(testName, testDesc);
		Task task2 = new Task(testName, testDesc);
		Task task3 = new Task(testName, testDesc);
		
		String id1 = task1.getTaskId();
		String id2 = task2.getTaskId();
		String id3 = task3.getTaskId();
		
		System.out.println("1: "+ id1 +" 2: "+ id2 +" 3: " + id3);
		
		assertNotEquals(id1, id2, "IDs are not unique");
		assertNotEquals(id2, id3, "IDs are not unique");
		assertNotEquals(id1, id3, "IDs are not unique");
	}
	
	@Test
	@DisplayName("Task name may not be null")
	void nullTaskNameTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Task(noName,testDesc);});
		
	}
	
	@Test
	@DisplayName("Task name may not exceed 20 characters")
	void longTaskNameTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Task(longName,testDesc);});
		
	}
	
	@Test
	@DisplayName("Task description may not be null")
	void nullTaskDescriptionTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Task(testName,noDesc);});
		
	}
	
	@Test
	@DisplayName("Task description may not exceed 50 characters")
	void longTaskDescriptionTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Task(testName,longDesc);});
		
	}

}
