package appointment;

import java.util.Date;

//The Appointment class represents an individual appointment with specific requirements as stated in clients requests/persona
public class Appointment {
 private final String appointmentId; //  ID for the appointment should be unique
 private final Date appointmentDate; // Date of the appointment
 private final String description;   // Description of the appointment

 // Constructor for Appointment class
 public Appointment(String appointmentId, Date appointmentDate, String description) {
     // Validate appointmentId: it must not be null, longer than 10 characters, or empty
     if (appointmentId == null || appointmentId.length() > 10) {
         throw new IllegalArgumentException("Appointment ID must be non-null and at most 10 characters long.");
     }
     this.appointmentId = appointmentId;

     // Validate appointmentDate: it must not be null or in the past, basically has to be in the future!!
     if (appointmentDate == null || appointmentDate.before(new Date())) {
         throw new IllegalArgumentException("Appointment date must be non-null and must not be in the past.");
     }
     this.appointmentDate = appointmentDate;

     // Validating the description: it must not be null or longer than 50 characters as directed by instuction, client, perona
     if (description == null || description.length() > 50) {
         throw new IllegalArgumentException("Description must be non-null and at most 50 characters long.");
     }
     this.description = description;
 }

 // Getter methods
 public String getAppointmentId() {
     return appointmentId;
 }

 public Date getAppointmentDate() {
     return appointmentDate;
 }

 public String getDescription() {
     return description;
 }
}
