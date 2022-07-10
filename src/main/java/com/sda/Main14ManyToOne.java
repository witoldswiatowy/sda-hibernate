package com.sda;

import com.sda.entity.Book;
import com.sda.entity.Client;
import com.sda.entity.Husband;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main14ManyToOne {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client janusz = new Client("Janusz");

        janusz.addBook(new Book("Harry Potter"));
        janusz.addBook(new Book("Władca Pierścienii"));
        janusz.addBook(new Book("Wiedzmiń"));

        session.persist(janusz);

        transaction.commit();
        session.close();
    }
}
