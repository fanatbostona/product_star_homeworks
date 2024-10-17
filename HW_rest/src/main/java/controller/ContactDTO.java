package controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import manager.Contact;

public class ContactDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("phoneNumber")
    private String phone_number;

    @JsonProperty("email")
    private String email_address;


    public ContactDTO(Contact contact) {
        this.name = contact.getName();
        this.surname = contact.getSurname();
        this.phone_number = contact.getPhone_number();
        this.email_address = contact.getEmail_address();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }
}
