package com.Course;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
    private static final SessionFactory ourSessionFactory = new Configuration().configure("com/Course/hibernate.cfg.xml").buildSessionFactory();

    /*static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }*/

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
}
