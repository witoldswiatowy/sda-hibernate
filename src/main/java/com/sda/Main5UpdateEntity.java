package com.sda;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main5UpdateEntity {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog1 = session.find(Dog.class, 17L); //select
        dog1.setAge(14); //przy drugim uruchomieniu, stan z początku i na końcu się nieróżni więc Dirty Checking nie znajdzie zmian i ich nie wprodzi, bo nie ma co

        Dog dog2 = new Dog();
        dog2.setId(18L);
        dog2.setName("Sonia");
        dog2.setAge(11);
        dog2.setRace("Buldgo");
        session.update(dog2); //zmienia całą krotke, jak nie wypełnimy jakiś danych to beda null

        transaction.commit();
        session.close();
    }
}
