package org.example;


import jakarta.persistence.*;

@Entity
@Table(name = "CONTACT")
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "phone_number", nullable = false)
    private String phone_number;
    @Column(name = "email", nullable = false)
    private String email_address;

    public Contact() {

    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
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

    public long getId() {
        return id;
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
