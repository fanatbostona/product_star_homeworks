package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.file.Paths;
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


        ContactReader contactReader = new ContactReader();
        var contacts = contactReader.readFromFile(Paths.get("/Users/fanatbostona/Desktop/HW_Jdbc/src/main/java/org/example/contacts.csv"));
        contactDao.saveAll(contacts);

        var all_contacts = contactDao.getAllContacts();

        System.out.println(all_contacts);




    }
}