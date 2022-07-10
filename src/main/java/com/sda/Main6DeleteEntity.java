package com.sda;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;

public class Main6DeleteEntity {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Dog dog = new Dog();
            dog.setId(20L);
            session.delete(dog);
            transaction.commit();
        } catch (OptimisticLockException e) {
            System.out.println("Krotka o podanym id nie istnieje");
        }
        session.close();

        //remove działą dokładnie tak samo jako delete, ale jest z innego interfacu czyli tak samo jak z find i get
    }
}
