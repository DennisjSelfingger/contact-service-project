package appointment;


import java.util.HashMap;
import java.util.Map;

// The AppointmentService class manages a collection of appointments, to local memory, not using a data base so for now just storing in ram for trhis project
// NOTE TO SELF.....add a data base to this project later to make it more of a complex project
public class AppointmentService {
    private Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    // Add an appointment if the ID is unique if not give alternative statement and or error
    public void addAppointment(Appointment appointment) throws IllegalArgumentException {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete an appointment by ID
    public boolean deleteAppointment(String appointmentId) {
        if (appointments.containsKey(appointmentId)) {
            appointments.remove(appointmentId);
            return true;
        }
        return false;
    }

    // Retrieve an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}