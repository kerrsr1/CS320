package contact;

public class Task {
	
	private String taskId;
	private String taskName;
	private String taskDescription;

	//Task constructor
	public Task (String taskId, String taskName, String taskDescription) {
		
	setTaskId(taskId);
	setTaskName(taskName);
	setTaskDescription(taskDescription);
	}
	
	public void setTaskId(String taskId) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID");
		}
		this.taskId = taskId;
	}
	
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("invalid task name");
		}
		this.taskName = taskName;
	}
	
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("invalid task description");
		}
		this.taskDescription = taskDescription;
	}
	

	//task getters
	public String getTaskId() {
		return taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
}
