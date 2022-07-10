package com.sda;

import com.sda.entity.Husband;
import com.sda.entity.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main11OneToOne {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Husband adam = new Husband("Adam");
        Wife ewa = new Wife("Ewa");

//        adam.setWife(ewa);
        ewa.setHusband(adam);

        session.persist(ewa);
        session.persist(adam);

        transaction.commit();
        session.close();

    }
}
