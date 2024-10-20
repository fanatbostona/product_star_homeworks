package com.example.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryContactDAO implements ContactDAO{
    private long contactID = 1L;
    private final Map<Long, Contact> contactIDMap;

    public InMemoryContactDAO() {
        this.contactIDMap = new HashMap<>();
    }

    @Override
    public Contact addContact(String name, String surname, String phone_number, String email) {
        var contact = new Contact(name,surname,phone_number,email);
        contactIDMap.put(contactID++,contact);
        return contact;
    }

    @Override
    public Optional<Contact> findContact(long contactID) {
        return Optional.ofNullable(contactIDMap.get(contactID));
    }

    @Override
    public Contact getContact(long contactID) {
        return findContact(contactID)
                .orElseThrow(()-> new IllegalArgumentException("No contact with ID = " + contactID));
    }

    @Override
    public void setContact(String name, String surname, String phone_number, String email) {
        var contact = getContact(contactID);
        contact.editInformation(name,surname,phone_number,email);
    }

    @Override
    public Map<Long,Contact> getContacts() {
        return contactIDMap;
    }
}
