package com.sda;

import com.sda.entity.Dog;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main4FindEntity {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog1 = session.find(Dog.class,17L); //szuka krotki o podanym id
        if (dog1 != null) {
            System.out.println(dog1.getId());
            System.out.println(dog1.getName());
        }

        Dog dog2 = session.get(Dog.class,18L); //szuka krotki o podanym id i jest dokładnie tym samy co find
        if (dog2 != null) {                             //różnica jest tylko że ten pochodzi z interface hibernate
            System.out.println(dog2.getId());
            System.out.println(dog2.getName());
        }

        try{
        Dog dog3 = session.load(Dog.class,300L); //to jest szukanie krotki typu lazy. Ładuje object do pośrednika Proxy (disignePateren proxy) i daje mu id zapodane, wiec zwróci 300, ale dalszych informacji nie ma bo nie ma tego obiektu
            System.out.println(dog3.getId());              //bez bloku try, wywali błąd bo zrobieniu select.
            System.out.println(dog3.getName());             //tu dopiero jest select wyklonywany bo dopieru tu potrzne sa dane z bazy danych
        } catch (ObjectNotFoundException e) {
            System.out.println("Nie ma krotki o podanym id");
        }

        transaction.commit();
        session.close();
    }
}
