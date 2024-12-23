package appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

// Unit tests for the AppointmentService class
public class AppointmentServiceTest {
    private AppointmentService service;
    private Date futureDate;

    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1); // Ensure the date is in the future
        futureDate = calendar.getTime();
    }

    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("A001", futureDate, "First appointment");
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("A001"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        Appointment appointment1 = new Appointment("A001", futureDate, "First appointment");
        service.addAppointment(appointment1);
        Appointment appointment2 = new Appointment("A001", futureDate, "Duplicate appointment");
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
        
        assertEquals("Appointment ID already exists.", exception.getMessage());
    }

    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("A002", futureDate, "Second appointment");
        service.addAppointment(appointment);
        assertTrue(service.deleteAppointment("A002"));
    }

    @Test
    public void testDeleteNonexistentAppointment() {
        assertFalse(service.deleteAppointment("A999")); // ID that does not exist
    }
}