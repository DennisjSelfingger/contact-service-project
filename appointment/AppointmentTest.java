package appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Calendar;

// Unit tests for the Appointment class
public class AppointmentTest {

    @Test
    public void testValidAppointmentCreation() {
        // Use a future date for validation
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1); // Add one day to the current date
        Date futureDate = calendar.getTime();

        // Test with valid inputs
        Appointment appointment = new Appointment("12345", futureDate, "Doctor's appointment");
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor's appointment", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentIdTooLong() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        // Test ID longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Description");
        });
    }

    @Test
    public void testInvalidAppointmentIdNull() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        // Test null ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Description");
        });
    }

    @Test
    public void testInvalidAppointmentDateInPast() {
        // Use a past date for validation
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); // Subtract one day from the current date
        Date pastDate = calendar.getTime();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Description");
        });
    }

    @Test
    public void testInvalidAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Description");
        });
    }

    @Test
    public void testInvalidDescriptionTooLong() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        // Test description longer than 50 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, "This description is way too long to be valid for the appointment.");
        });
    }

    @Test
    public void testInvalidDescriptionNull() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
    }

    // New Boundary and Edge Case Tests
    @Test
    public void testValidAppointmentIdBoundary() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        // Test valid boundary of 10 characters
        Appointment appointment = new Appointment("1234567890", futureDate, "Valid Description");
        assertEquals("1234567890", appointment.getAppointmentId());
    }

    @Test
    public void testInvalidAppointmentIdBoundary() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        // Test invalid boundary of 11 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Description");
        });
    }

    @Test
    public void testValidDescriptionBoundary() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        // Test valid boundary of 50 characters
        String validDescription = "12345678901234567890123456789012345678901234567890";
        Appointment appointment = new Appointment("12345", futureDate, validDescription);
        assertEquals(validDescription, appointment.getDescription());
    }

    @Test
    public void testInvalidDescriptionBoundary() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        // Test invalid boundary of 51 characters
        String invalidDescription = "123456789012345678901234567890123456789012345678901";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, invalidDescription);
        });
    }

    @Test
    public void testValidAppointmentDateBoundary() {
        Date currentDate = new Date(); // Current date-time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.SECOND, 1); // Add 1 second to ensure it's a future date
        Date validDate = calendar.getTime();

        Appointment appointment = new Appointment("12345", validDate, "Description");
        assertEquals(validDate, appointment.getAppointmentDate());
    }

    @Test
    public void testInvalidAppointmentDateBoundary() {
        Date currentDate = new Date(); // Current date-time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.SECOND, -1); // Subtract 1 second to make it past
        Date invalidDate = calendar.getTime();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", invalidDate, "Description");
        });
    }
}
