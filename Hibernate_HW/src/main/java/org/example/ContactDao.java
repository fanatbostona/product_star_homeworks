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


}
