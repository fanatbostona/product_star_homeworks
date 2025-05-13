package org.example;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        prepareData(context);

        var sessionFactory = context.getBean(SessionFactory.class);

        try (var session = sessionFactory.openSession()) {

            var query = session.createQuery("FROM Contact c");
            var contacts = query.list();
            System.out.println("GET ALL CONTACTS" + contacts);

        }
    }

    private static void prepareData(ApplicationContext context) {
        var contactDao = context.getBean(ContactDao.class);
        var contacts = contactDao.getAllContacts();
        System.out.println(contacts);
    }

}