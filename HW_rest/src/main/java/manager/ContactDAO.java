package manager;

import java.util.Optional;

public interface ContactDAO {

    Contact addContact(String name, String surname, String phone_number, String email);
    Optional<Contact> findContact(long contactID);
    Contact getContact(long contactID);
    void setContact(String name, String surname, String phone_number, String email);

}
