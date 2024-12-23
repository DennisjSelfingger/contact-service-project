package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        assertNotNull(service.getContact("1234567890"));
        assertEquals("John", service.getContact("1234567890").getFirstName());
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

    @Test
    void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        service.updateContact("1234567890", "Jane", "Doe", "9876543210", "456 Maple St");
        assertEquals("Jane", service.getContact("1234567890").getFirstName());
        assertEquals("9876543210", service.getContact("1234567890").getPhone());
    }
}

