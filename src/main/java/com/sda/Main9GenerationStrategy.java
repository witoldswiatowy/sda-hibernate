package com.sda;

import com.sda.entity.Tiger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main9GenerationStrategy {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new Tiger("Surya 1"));
        session.persist(new Tiger("Surya 2"));
        session.persist(new Tiger("Surya 3"));
        session.persist(new Tiger("Surya 4"));
        session.persist(new Tiger("Surya 5"));

        transaction.commit();
        session.close();
    }
}
