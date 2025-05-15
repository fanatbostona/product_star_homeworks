package org.example;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ContactDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ContactDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Contact> getAllContacts() {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("SELECT c FROM Contact c").getResultList();
        }
    }

    public Contact getContact(Long id) {
        try (var session = sessionFactory.openSession()) {
            return session.get(Contact.class, id);
        }
    }

    public long addContact(String name, String surname, String phone_number, String email) {
        try (var session = sessionFactory.openSession()) {
            Contact newContact = new Contact();
            newContact.editInformation(name, surname, phone_number, email);
            var transaction = session.beginTransaction();
            var contactID = (long) session.save(newContact);
            transaction.commit();
            return contactID;
        }
    }

    public void updatePhoneNumber(long ID, String new_phone_number) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            var contact = getContact(ID);
            if (contact != null) {
                contact.setPhone_number(new_phone_number);
                session.update(contact);
            }
            transaction.commit();
        }
    }

    public void updateEmail(long ID, String new_email) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            var contact = getContact(ID);
            if (contact != null) {
                contact.setEmail_address(new_email);
                session.update(contact);
            }
            transaction.commit();
        }
    }

    public void deleteContact(long ID) {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            var contact = getContact(ID);
            if (contact != null) {
                session.delete(contact);
            }
            transaction.commit();
        }
    }


}
