package com.sda;

import com.sda.entity.Book;
import com.sda.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main19JoinPreparation {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("DELETE FROM Book b").executeUpdate(); //to małe "b" to jest przypisanie nazwy do Book - chyba. Bo w Main18 jest h.id
        session.createQuery("DELETE FROM Client c").executeUpdate();

        Client client1 = new Client("Jan");
        Client client2 = new Client("Ala");
        Client client3 = new Client("Tomek");
        Client client4 = new Client("Małgorzata");

        client1.addBook(new Book("book-1"));
        client1.addBook(new Book("book-2"));
        client1.addBook(new Book("book-3"));

        client2.addBook(new Book("book-4"));
        client2.addBook(new Book("book-5"));
        client2.addBook(new Book("book-6"));

        session.persist(client1);
        session.persist(client2);
        session.persist(client3);
        session.persist(client4);

        transaction.commit();
        session.close();

    }
}
