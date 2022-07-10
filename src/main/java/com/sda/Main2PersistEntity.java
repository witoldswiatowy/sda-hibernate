package com.sda;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main2PersistEntity {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = new Dog("Ares", 10, "Terier");
        session.persist(dog);                                                   //na dog "ctrl + alt + n" i przypisuje zmienna do jednej linii
        session.persist(new Dog("Szaki", 15, "Foksterrier"));
        session.persist(new Dog("Burek", 5, "Kubdel"));
        session.persist(new Dog("Kobi", 10, "Person Terrier"));
        session.persist(new Dog("Chaps", 18, "Jamnik"));
        session.persist(new Dog("Reksio", 3, "Labrador"));
        session.persist(new Dog("Pimpek", 15, "Pitbul"));


        transaction.commit();
        session.close();

    }
}
