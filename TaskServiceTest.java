package contact;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	
	private String name1, name2, name3, description1, description2, description3;
	
	@BeforeEach
	void setup() {
		
		name1 = "name1";
		name2 = "name2";
		name3 = "name3";
		description1 = "task description up to 50 chars";
		description2 = "second task description";
		description3 = "third task description";
	
	}
	
	//Testing the ability to add 2 unique tasks
	@Test
	void testAddTask() {
		TaskService service = new TaskService();
		
		Task addedTask1 = service.addTask(name1, description1);
		Task task1 = service.getTask(addedTask1.getTaskId());
		
		assertTrue(task1.getTaskId().equals(addedTask1.getTaskId()));
		assertTrue(task1.getTaskName().equals(name1));
		assertTrue(task1.getTaskDescription().equals(description1));
		
		Task addedTask2 = service.addTask(name2, description2);
		Task task2 = service.getTask(addedTask2.getTaskId());
		
		assertTrue(task2.getTaskId().equals(addedTask2.getTaskId()));
		assertTrue(task2.getTaskName().equals(name2));
		assertTrue(task2.getTaskDescription().equals(description2));
	}
	
	//Testing to make sure some tasks can be deleted while others are not
	@Test 
	void testDeleteTask() {
		
		TaskService service = new TaskService();
		
		Task addedTask1 = service.addTask(name1, description1);
		Task addedTask2 = service.addTask(name2, description2);
		Task addedTask3 = service.addTask(name3, description3);
		
		assertTrue(service.deleteTask(addedTask1.getTaskId()));
		assertTrue(service.deleteTask(addedTask3.getTaskId()));
		
		Task task1 = service.getTask(addedTask2.getTaskId());
		assertTrue(task1.getTaskId().equals(addedTask2.getTaskId()));
		assertTrue(task1.getTaskName().equals(name2));
		assertTrue(task1.getTaskDescription().equals(description2));
	}
	
	//testing creating a task and then updating the fields
	@Test
	void testUpdateTask() {
		
		TaskService service = new TaskService();
		
		Task addedTask1 = service.addTask(name1, description1);
		service.updateTask(addedTask1.getTaskId(), name2, description2);
		
		Task task1 = service.getTask(addedTask1.getTaskId());
		
		//checks to make sure the task got updated
		assertTrue(task1.getTaskName().equals(name2));
		assertTrue(task1.getTaskDescription().equals(description2));
	}

	@Test
	void testGetTaskForExceptionUse() {
		
		TaskService service = new TaskService();
		service.addTask(name1, description1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getTask("2"); //contact with ID 2 should not exist yet	
		});
	}
	
	@Test
	void testDeleteTaskForExceptionUse() {
		
		TaskService service = new TaskService();
		service.addTask(name1, description1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask("2"); //contact with ID 2 should not exist yet, so can't delete	
		});
	}
	
}
