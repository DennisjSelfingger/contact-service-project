package contact;

public class Contact {
    // Fields for the Contact object, 'final' ensures contactId is immutable once set.
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor for initializing a new Contact object with validation for each parameter.
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate contactId: must not be null and must not exceed 10 characters.
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        // Validate firstName: must not be null and must not exceed 10 characters.
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        // Validate lastName: must not be null and must not exceed 10 characters.
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        // Validate phone: must not be null and must exactly be 10 digits.
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        // Validate address: must not be null and must not exceed 30 characters.
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        // Assign validated values to fields.
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for contactId, immutable so no setter.
    public String getContactId() {
        return contactId;
    }

    // Getter for firstName.
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName with validation.
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    // Getter for lastName.
    public String getLastName() {
        return lastName;
    }

    // Setter for lastName with validation.
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    // Getter for phone.
    public String getPhone() {
        return phone;
    }

    // Setter for phone with validation.
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    // Getter for address.
    public String getAddress() {
        return address;
    }

    // Setter for address with validation.
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
