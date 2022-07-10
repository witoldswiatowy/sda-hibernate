package com.sda;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

    private static SessionFactory sessionFactory; //to jest singletone

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    } //ten blok kodu wywoła się kiedy użyjemy pierwszy raz jakąs statyczna metode lub statyczne pole z tej klasy  i wywola sie tylk oraz

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
