package task;


import java.util.HashMap;
import java.util.Map;




public class TaskService {
	
	//Create list to store tasks
	public Map<String,Task> taskMap = new HashMap<String,Task>();
	
	//Method to add to list
	public void addTask(String taskName,String taskDescription) {
		
		Task task = new Task(taskName, taskDescription);
		String id = task.getTaskId(); //Grab id from newly created instance
		duplicateIdCheck(id, task);
		
	}
	
	//Display all tasks instances for test purposes
	public void displayTasks() {
		for (String i : taskMap.keySet()) {
			  System.out.println("Task Id: " + taskMap.get(i).getTaskId());
			  System.out.println("Task Name: " + taskMap.get(i).getTaskName());
			  System.out.println("Task Description: " + taskMap.get(i).getTaskDescription());
			}
		}

	
	//Method to delete tasks
	public void deleteTasks(String taskId) {
		if(taskMap.containsKey(taskId)) {
			taskMap.remove(taskId);
		} else {
			System.out.println("Task Id: " + taskId + " cannot be found.");
		}
	}
	
	//Method to update task name
	public void updateTaskName(String updatedTaskName, String taskId) {
		if(taskMap.containsKey(taskId)) {
			taskMap.get(taskId).setTaskName(updatedTaskName);
		} else {
			System.out.println("Task Id: " + taskId + " cannot be found.");
		}

	}
	
	//Method to update task description
	public void updateTaskDescription(String updatedTaskDescription, String taskId) {
		if(taskMap.containsKey(taskId)) {
			taskMap.get(taskId).setTaskDescription(updatedTaskDescription);
		} else {
			System.out.println("Task Id: " + taskId + " cannot be found.");
		}
	}
	
	//Method return taskMap
	
	public Map<String, Task> getTaskMap(){
		return taskMap;
	}
	
	public void duplicateIdCheck(String instanceId, Task object) {
		 
		 if(taskMap.containsKey(instanceId)) {
			 System.out.println("Task ID already exists.");
			 return;
		 }
		 else {
			 taskMap.put(instanceId, object);
		 }
	}
}
