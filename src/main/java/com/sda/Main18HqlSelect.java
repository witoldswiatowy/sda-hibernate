package com.sda;

import com.sda.entity.Husband;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main18HqlSelect {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Query<Husband> queryOne = session.createQuery("SELECT h FROM Husband h", Husband.class);
        List<Husband> resultOne = queryOne.getResultList();
        resultOne.stream().map(Husband::getName).forEach(System.out::println);

        System.out.println("-------");

        Query<String> queryTwo = session.createQuery("SELECT h.name FROM Husband h", String.class);
        List<String> resultTwo = queryTwo.getResultList();
        resultTwo.forEach(System.out::println);

        System.out.println("--------");

        Query<Husband>queryThree = session.createQuery("SELECT h FROM Husband h WHERE h.id = :id", Husband.class);
        queryThree.setParameter("id", 3L);
        Husband resultThree = queryThree.getSingleResult();
        System.out.println(resultThree.getName());

        System.out.println("--------");

        String name = session.createQuery("SELECT h FROM Husband h WHERE h.id = :id", Husband.class)
                .setParameter("id", 3L)
                .getSingleResult()
                .getName();

        System.out.println(name);

        transaction.commit();
        session.close();
    }
}
