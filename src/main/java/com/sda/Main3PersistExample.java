package com.sda;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main3PersistExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = new Dog("Azor", 11, "Husky");
        System.out.println(dog.getId()); // null
        session.persist(dog); // persistent (A)
        System.out.println(dog.getId()); // np.7

        dog.setAge(12);

        session.evict(dog); //detached
        System.out.println(dog.getId());// np.7

        dog.setRace("Chihuahua");

        transaction.commit(); //commit nic nie z update bo dog został odłąćzony, więc nawet wiek się nie zmieni. bo porównuje stan A do B, a nie ma stanu B
        session.close();
    }
}
