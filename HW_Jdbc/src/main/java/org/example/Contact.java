package org.example;

import java.util.UUID;

public class Contact {

    private final long id;
    private String name;
    private String surname;
    private String phone_number;
    private String email_address;


    public Contact(Long id, String n, String s, String pn, String ea) {
        this.id = id;
        this.name = n;
        this.surname = s;
        this.phone_number = pn;
        this.email_address = ea;
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

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email_address='" + email_address + '\'' +
                '}';
    }

    public void editInformation(String n, String s, String pn, String ea) {
        this.name = n;
        this.surname = s;
        this.phone_number = pn;
        this.email_address = ea;
    }
}
