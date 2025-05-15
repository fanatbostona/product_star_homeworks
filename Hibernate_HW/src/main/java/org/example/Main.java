package org.example;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


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
            updatePhone(sessionFactory,query, ID, new_phone);

            String new_email = "stasons.mail@gmail.com";
            updateEmail(sessionFactory,query,ID,new_email);

            Long deleteID = 202L;
            deleteContact(sessionFactory,query,deleteID);

        }
    }

    @Transactional
    public static void updatePhone(SessionFactory sessionFactory, Query query, long ID, String new_phone) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                query = session.createQuery("UPDATE Contact SET phone_number =: new_phone WHERE id =: id");
                query.setParameter("new_phone", new_phone);
                query.setParameter("id", ID);
                int updatedRows = query.executeUpdate();
                transaction.commit();
                System.out.println("Обновлено строк (phone_number): " + updatedRows);
            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    @Transactional
    public static void updateEmail(SessionFactory sessionFactory, Query query, long ID, String new_email) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                query = session.createQuery("UPDATE Contact SET email =: new_email WHERE id =: id");
                query.setParameter("new_email", new_email);
                query.setParameter("id", ID);
                int updatedRows = query.executeUpdate();
                transaction.commit();
                System.out.println("Обновлено строк (email): " + updatedRows);
            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    public static void deleteContact(SessionFactory sessionFactory, Query query, Long ID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                query = session.createQuery("DELETE FROM Contact WHERE id =: id");
                query.setParameter("id", ID);
                int deleteRows = query.executeUpdate();
                transaction.commit();
                System.out.println("Удалено строк: " + deleteRows);
            } catch (Exception e) {
                if (transaction != null) transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    private static void prepareData(ApplicationContext context) {
        var contactDao = context.getBean(ContactDao.class);
        var contacts = contactDao.getAllContacts();
        System.out.println(contactDao.addContact("olga", "gertel", "+7960", "olgagertel@mail.ru"));

    }

}