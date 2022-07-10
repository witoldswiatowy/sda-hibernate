package com.sda;

import com.sda.entity.Book;
import com.sda.entity.Client;
import com.sda.entity.School;
import com.sda.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main15ManyToMany {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        School school1 = new School("UP");
        School school2 = new School("PG");

        Student student1 = new Student("Jan");
        Student student2 = new Student("Ola");
        Student student3 = new Student("Andrzej");

        school1.addStudent(student1);
        school1.addStudent(student2);

        school2.addStudent(student2);
        school2.addStudent(student3);

        session.persist(school1);
        session.persist(school2);

        transaction.commit();
        session.close();
    }
}
