package com.sda;

import com.sda.entity.Bird;
import com.sda.entity.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main8Uuid {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        session.persist(new Cat("Garfield"));
        session.persist(new Bird("Tweety"));

        transaction.commit();
        session.close();
    }
}
