package com.arakelyan.hibernate.demo.classes;


import com.arakelyan.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tempStudent = new Student("log4jTest", "log4jTest", "log@4j.test");

            session.beginTransaction();

            session.save(tempStudent);

            session.getTransaction().commit();

        }
        finally {
            session.close();
        }

    }
}
