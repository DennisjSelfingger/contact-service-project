package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Map to store contacts using their contactId as the key.Map where each key is a String representing the contact's ID
    private final Map<String, Contact> contacts = new HashMap<>();

    // Method to add a new contact to the map after checking for unique contactId.
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Method to remove a contact from the map using the contactId.
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId);
    }

    // Method to update existing contact details; only updates fields that pass validation.
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        if (firstName != null && firstName.length() <= 10) {
            contact.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() <= 10) {
            contact.setLastName(lastName);
        }
        if (phone != null && phone.length() == 10) {
            contact.setPhone(phone);
        }
        if (address != null && address.length() <= 30) {
            contact.setAddress(address);
        }
    }

    // Method to retrieve a contact by their contactId.
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
