package contact;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;

public class TaskService {
	
	private String name1, name2, description1, description2;

	int Id = 0;
	
	
	//create taskList array
	private ArrayList<Task> taskList = new ArrayList<>();
	
	public Task getTask(String ID) {
		
		Iterator<Task> itr = taskList.iterator();
		
		while (itr.hasNext()) {
			Task task = itr.next();
			if (task.getTaskId().equals(ID)) {
					
				return task;
							
			}
		}
		throw new IllegalArgumentException("no such task");
	}

	//adds a task to the taskList array
	public Task addTask(String taskName, String taskDescription) {

		Id++; //increment ID to make a unique ID
		
		//convert integer to string for ArrayList
		String taskId = Integer.toString(Id);
		//create task object
		Task task = new Task(taskId, taskName, taskDescription);
		//add contact to list
		taskList.add(task);
		
		return task;
		
	}
	
	//deletes a contact from the contactLast array
	public boolean deleteTask(String ID) {
		
	
		Iterator<Task> itr = taskList.iterator();
		
		int idx = 0; //index to hold appointment position on list
		
		//iterates through list and deletes task if matching ID is found, else throws exception
		while (itr.hasNext()) {
			Task task = itr.next();
			if (!task.getTaskId().equals(ID)) {
				idx++;
					
			} else {
				taskList.remove(idx);
				return true;
				}
			}
		throw new IllegalArgumentException("can't delete task");
	}
	
	//updates an existing task
	public Task updateTask(String taskId, String taskName, String taskDescription) {
			
			Task task = getTask(taskId);
					task.setTaskName(taskName);
					task.setTaskDescription(taskDescription);
					
			return task;
			}
	
}
