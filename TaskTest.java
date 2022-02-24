package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class TaskTest {
	
	String id, name, description, tooLongId, tooLongName, tooLongDescription;
	
	@BeforeEach
	void setup() {
		id = "taskID1234";
		name = "taskNameLessThan20";
		description = "taskdescription up to 50 chars";
		tooLongId = "taskID12345";
		tooLongName = "taskNameTooLong123456";
		tooLongDescription = "task description is more than 50 characters long which violates the requirements of the task description";
		
	}

	@Test
	void testTask() {
		Task task = new Task(id, name, description);
		assertTrue(task.getTaskId().equals(id));
		assertTrue(task.getTaskName().equals(name));
		assertTrue(task.getTaskDescription().equals(description));
				
	}
	
	@Test
	void testTaskIdExceptionsUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(tooLongId, name, description);
		});
	}
	
	@Test
	void testTaskNameExceptionsUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, tooLongName, description);
		});
	}
	
	@Test
	void testTaskDescriptionExceptionsUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, name, tooLongDescription);
		});
	}

}
