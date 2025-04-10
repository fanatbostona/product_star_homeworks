package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import org.example.config.ApplicationConfiguration;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_data","postgres", "fuckboifuckboi");
            System.out.println("Connection is ok");
        } catch (SQLException e) {
            System.out.println("Connection is not ok");
            throw new RuntimeException(e);
        }

        var applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        var contactDao = applicationContext.getBean(ContactDao.class);

        var contact = contactDao.getContact(1L);
        System.out.println(contact);

        contactDao.updateEmail(1L,"stasons");
        contact = contactDao.getContact(1L);
        System.out.println(contact);

        contactDao.updatePhoneNumber(1L,"+7906");
        contact = contactDao.getContact(1L);
        System.out.println(contact);

        var newContact = contactDao.addContact("Olga", "Gertel","+7960","olgagertel");
        System.out.println(newContact);

        var contacts = contactDao.getAllContacts();
        System.out.println(contacts);

        contactDao.deleteContact(2L);
        contacts = contactDao.getAllContacts();
        System.out.println(contacts);


    }
}