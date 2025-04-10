package org.example;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface ContactDao {


    List<Contact> getAllContacts();

    Contact getContact(Long id);

    Contact addContact(String n, String s, String pn, String ea);

    void updatePhoneNumber(Long id, String newPN);

    void updateEmail(Long id, String newEmail);

    void deleteContact(Long id);

}
