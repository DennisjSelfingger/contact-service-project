package task;

public class Task {
    private final String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException(" task ID cannot be longer than 10 characters...or null");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid cannot be null or linger than 20 characters");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("The description can't be longer than 50 characters");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
