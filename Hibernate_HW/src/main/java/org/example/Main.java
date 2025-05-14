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
            System.out.println("GET ALL CONTACTS : "  + contacts);


            long ID = 1;
            query = session.createQuery("FROM Contact c WHERE c.id = :id");
            query.setParameter("id", ID);
            var contact = query.getSingleResult();
            System.out.println("CONTACT WITH ID = " + ID + " : " +  contact);

            String new_phone = "+7901";
            query = session.createQuery("UPDATE Contact SET phone_number =: new_phone WHERE id =: id");
            query.setParameter("new_phone", new_phone);
            query.setParameter("id", ID);
            int rows = query.executeUpdate();
            System.out.println(rows);



        }
    }

    private static void prepareData(ApplicationContext context) {
        var contactDao = context.getBean(ContactDao.class);
        var contacts = contactDao.getAllContacts();

        //System.out.println(contactDao.addContact("olga", "gertel", "+7960", "olgagertel@mail.ru"));

    }

}