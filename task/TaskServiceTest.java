package task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService service;

    @BeforeEach
    void setup() {
        service = new TaskService();
    }

    // Test adding a task successfully
    @Test
    void testAddTask() {
        Task task = new Task("001", "Complete Homework", "Description One");
        service.addTask(task);
        assertEquals(task, service.getTask("001"));
    }

    // Test adding a task that already exists throws exception
    @Test
    void testAddTaskThatExists() {
        Task task = new Task("001", "Complete Homework", "Description One");
        service.addTask(task);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.addTask(task));
        assertEquals("Task ID already exists", exception.getMessage());
    }

    // Test adding a task with an ID that is too long
    @Test
    void testAddTaskExceedIdLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Task("12345678901", "Homework", "Description"));
        assertEquals("task ID cannot be longer than 10 characters...or null", exception.getMessage());
    }

    // Test deleting an existing task
    @Test
    void testDeleteExistingTask() {
        Task task = new Task("001", "Complete Homework", "Description One");
        service.addTask(task);
        service.deleteTask("001");
        assertNull(service.getTask("001"));
    }

    // Test deleting a non-existing task does not throw an error
    @Test
    void testDeleteNonExistingTask() {
        assertNull(service.getTask("999"));  // Asserts that getting a non-existing task returns null
    }

    // Test updating an existing task
    @Test
    void testUpdateExistingTask() {
        Task task = new Task("001", "Complete Homework", "Description One");
        service.addTask(task);
        service.updateTask("001", "Updated Homework", "Updated Description");
        Task updatedTask = service.getTask("001");
        assertNotNull(updatedTask);
        assertEquals("Updated Homework", updatedTask.getName());
        assertEquals("Updated Description", updatedTask.getDescription());
    }

    // Test updating a non-existing task throws exception
    @Test
    void testUpdateNonExistingTask() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.updateTask("002", "Update Attempt", "No Task"));
        assertEquals("Task not found", exception.getMessage());
    }

    // Test adding a task with null ID
    @Test
    void testAddTaskNullId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Task(null, "Homework", "Description"));
        assertEquals("task ID cannot be longer than 10 characters...or null", exception.getMessage());
    }

    // Test adding a task with maximum name length
    @Test
    void testAddTaskMaxNameLength() {
        String longName = "12345678901234567890"; // 20 characters
        Task task = new Task("002", longName, "Description");
        service.addTask(task);
        assertEquals(longName, service.getTask("002").getName());
    }

    // Test adding a task with a name that is too long
    @Test
    void testAddTaskExceedNameLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            new Task("003", "123456789012345678901", "Description")); // 21 characters
        assertEquals("Invalid cannot be null or linger than 20 characters", exception.getMessage());
    }
}
