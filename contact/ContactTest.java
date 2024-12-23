package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Main St");
    }

    @Test
    void testContact_Constructor() {
        assertAll("constructor",
            () -> assertEquals("1234567890", contact.getContactId()),
            () -> assertEquals("Jane", contact.getFirstName()),
            () -> assertEquals("Doe", contact.getLastName()),
            () -> assertEquals("1234567890", contact.getPhone()),
            () -> assertEquals("123 Main St", contact.getAddress())
        );
    }

    @Test
    void testContact_NullId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Jane", "Doe", "1234567890", "123 Main St"));
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
    void testContact_LongId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("01234567890", "Jane", "Doe", "1234567890", "123 Main St"));
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
    void testContact_NullFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", null, "Doe", "1234567890", "123 Main St"));
        assertEquals("Invalid first name", exception.getMessage());
    }

    @Test
    void testContact_LongFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "JaneJaneJane", "Doe", "1234567890", "123 Main St"));
        assertEquals("Invalid first name", exception.getMessage());
    }

    @Test
    void testContact_NullLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", null, "1234567890", "123 Main St"));
        assertEquals("Invalid last name", exception.getMessage());
    }

    @Test
    void testContact_LongLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "DoeDoeDoeDoe", "1234567890", "123 Main St"));
        assertEquals("Invalid last name", exception.getMessage());
    }

    @Test
    void testContact_NullPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "Doe", null, "123 Main St"));
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    void testContact_InvalidPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "Doe", "12345678", "123 Main St"));
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    void testContact_NullAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "Doe", "1234567890", null));
        assertEquals("Invalid address", exception.getMessage());
    }

    @Test
    void testContact_LongAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Main St North West South East"));
        assertEquals("Invalid address", exception.getMessage());
    }

    // Boundary tests for maximum allowed length
    @Test
    void testMaxLengthFirstName() {
        assertDoesNotThrow(() -> new Contact("1234567890", "JohnJohnJo", "Doe", "1234567890", "123 Elm St"));
    }
    //this should cause an  failure not error then becasue i added more than 10 to the name
    @Test
    void testOverMaxLengthFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 Elm St"));
        assertEquals("Invalid first name", exception.getMessage());
    }
//this should cause a failure not error then becasue i added more than 10 to the name
    @Test
    void testMaxLengthLastName() {
        assertDoesNotThrow(() -> new Contact("1234567890", "John", "DoeDoeDoeDo", "1234567890", "123 Elm St"));
    }

    @Test
    void testOverMaxLengthLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "DoeDoeDoeDoe", "1234567890", "123 Elm St"));
        assertEquals("Invalid last name", exception.getMessage());
    }

    @Test
    void testMaxLengthAddress() {
        assertDoesNotThrow(() -> new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St Elm St Elm"));
    }

    @Test
    void testOverMaxLengthAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "1234567890", "123 Elm St Elm St Elm St"));
        assertEquals("Invalid address", exception.getMessage());
    }
}
