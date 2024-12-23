package task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    // Test creating a task with valid parameters
    @Test
    void testTaskCreationValid() {
        Task task = new Task("123", "Complete Homework", "Finish the assignment by tonight.");
        assertNotNull(task);
        assertEquals("123", task.getTaskId());
        assertEquals("Complete Homework", task.getName());
        assertEquals("Finish the assignment by tonight.", task.getDescription());
    }

    // Test task ID null and over length limit
    @Test
    void testTaskIdInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Test Task", "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Test Task", "Description"));
    }

    // Test name null and over length limit
    @Test
    void testNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Task("123", null, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "This name is definitely way too long for the task object", "Description"));
    }

    // Test description null and over length limit should give me 1 failure for this testing the boundries
    @Test
    void testDescriptionInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Test Task", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Test Task", "This description is certainly going to be too long because it exceeds the fifty characters limit that has been set for the description of a task object."));
    }

    // Test updating name within valid bounds
    @Test
    void testUpdateNameValid() {
        Task task = new Task("123", "Old Name", "Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    // Test updating description within valid bounds
    @Test
    void testUpdateDescriptionValid() {
        Task task = new Task("123", "Task Name", "Old Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    // Attempting to update task ID, which should not be possible
    @Test
    void testUpdateTaskId() {
        Task task = new Task("123", "Task Name", "Description");
        final String originalId = task.getTaskId();
        // This part of the test assumes you cannot change the ID since the setter shouldn't exist
        assertThrows(UnsupportedOperationException.class, () -> {
            // Suppose there was a method like task.setTaskId("321"), which should not exist
            // You would test it like this to ensure the ID remains unchanged
        });
        assertEquals(originalId, task.getTaskId());
    }
}
