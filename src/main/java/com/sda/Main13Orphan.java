package com.sda;

import com.sda.entity.Husband;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main13Orphan {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Husband husband1 = session.find(Husband.class, 4L);
        husband1.setWife(null);

        transaction.commit();
        session.close();
    }
}
