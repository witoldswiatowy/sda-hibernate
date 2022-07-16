package com.sda;

import com.sda.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main20HqlJoin {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Client> query = session.createQuery("SELECT DISTINCT c FROM Client c LEFT JOIN FETCH c.books", Client.class);
        List<Client> result = query.getResultList();

        result.forEach(System.out::println);

        transaction.commit();
        session.close();

    }
}

//         N+1         ------- przy 100 klientó było by 101 zapytan

//WYNIK zapytania "SELECT  c FROM Client c"
// 4 client i 5 zapytan
//        Client(id=2, name=Jan, books=[Book(id=4, name=book-1), Book(id=6, name=book-2), Book(id=5, name=book-3)])
//        Client(id=3, name=Ala, books=[Book(id=8, name=book-5), Book(id=7, name=book-4), Book(id=9, name=book-6)])
//        Client(id=4, name=Tomek, books=[])
//        Client(id=5, name=Małogorzata, books=[])
//
//        Hibernate: select client0_.id as id1_3_, client0_.name as name2_3_ from client client0_
//        Hibernate: select books0_.client_id as client_i3_1_0_, books0_.id as id1_1_0_, books0_.id as id1_1_1_, books0_.client_id as client_i3_1_1_, books0_.name as name2_1_1_ from book books0_ where books0_.client_id=?
//        Hibernate: select books0_.client_id as client_i3_1_0_, books0_.id as id1_1_0_, books0_.id as id1_1_1_, books0_.client_id as client_i3_1_1_, books0_.name as name2_1_1_ from book books0_ where books0_.client_id=?
//        Hibernate: select books0_.client_id as client_i3_1_0_, books0_.id as id1_1_0_, books0_.id as id1_1_1_, books0_.client_id as client_i3_1_1_, books0_.name as name2_1_1_ from book books0_ where books0_.client_id=?
//        Hibernate: select books0_.client_id as client_i3_1_0_, books0_.id as id1_1_0_, books0_.id as id1_1_1_, books0_.client_id as client_i3_1_1_, books0_.name as name2_1_1_ from book books0_ where books0_.client_id=?

//WYNIK zapytania "SELECT DISTINCT c FROM Client c LEFT JOIN c.books"
// 4 client i 5 zapytan
//        Client(id=2, name=Jan, books=[Book(id=4, name=book-1), Book(id=5, name=book-3), Book(id=6, name=book-2)])
//        Client(id=3, name=Ala, books=[Book(id=9, name=book-6), Book(id=7, name=book-4), Book(id=8, name=book-5)])
//        Client(id=4, name=Tomek, books=[])
//        Client(id=5, name=Małogorzata, books=[])
//
//        Hibernate: select distinct client0_.id as id1_3_, client0_.name as name2_3_ from client client0_ left outer join book books1_ on client0_.id=books1_.client_id
//        Hibernate: select books0_.client_id as client_i3_1_0_, books0_.id as id1_1_0_, books0_.id as id1_1_1_, books0_.client_id as client_i3_1_1_, books0_.name as name2_1_1_ from book books0_ where books0_.client_id=?
//        Hibernate: select books0_.client_id as client_i3_1_0_, books0_.id as id1_1_0_, books0_.id as id1_1_1_, books0_.client_id as client_i3_1_1_, books0_.name as name2_1_1_ from book books0_ where books0_.client_id=?
//        Hibernate: select books0_.client_id as client_i3_1_0_, books0_.id as id1_1_0_, books0_.id as id1_1_1_, books0_.client_id as client_i3_1_1_, books0_.name as name2_1_1_ from book books0_ where books0_.client_id=?
//        Hibernate: select books0_.client_id as client_i3_1_0_, books0_.id as id1_1_0_, books0_.id as id1_1_1_, books0_.client_id as client_i3_1_1_, books0_.name as name2_1_1_ from book books0_ where books0_.client_id=?



// --------------- bez problemu N+1  ------------------------

//    WYNIK zapytania "SELECT DISTINCT c FROM Client c LEFT JOIN FETCH c.books"
// 4 client i 1 zapytanie
//        Client(id=2, name=Jan, books=[Book(id=4, name=book-1), Book(id=5, name=book-3), Book(id=6, name=book-2)])
//        Client(id=3, name=Ala, books=[Book(id=8, name=book-5), Book(id=9, name=book-6), Book(id=7, name=book-4)])
//        Client(id=4, name=Tomek, books=[])
//        Client(id=5, name=Małogorzata, books=[])
//
//        Hibernate: select distinct client0_.id as id1_3_0_, books1_.id as id1_1_1_, client0_.name as name2_3_0_, books1_.client_id as client_i3_1_1_, books1_.name as name2_1_1_, books1_.client_id as client_i3_1_0__, books1_.id as id1_1_0__ from client client0_ left outer join book books1_ on client0_.id=books1_.client_id
