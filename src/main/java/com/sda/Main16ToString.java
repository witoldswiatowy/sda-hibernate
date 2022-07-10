package com.sda;

import com.sda.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main16ToString {
    public static void main(String[] args) {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

        Student student = session.find(Student.class, 3L);
        System.out.println(student);

    transaction.commit();
    session.close();


    }
}
