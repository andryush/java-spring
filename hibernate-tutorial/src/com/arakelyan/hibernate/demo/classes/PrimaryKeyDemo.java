package com.arakelyan.hibernate.demo.classes;

import com.arakelyan.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student newStudent1 = new Student("Andrey3", "Arakelyan3", "andrey3@arakelyan.com");
            Student newStudent2 = new Student("Andrey4", "Arakelyan4", "andrey4@arakelyan.com");
            Student newStudent3 = new Student("Andrey5", "Arakelyan5", "andrey5@arakelyan.com");

            session.beginTransaction();

            session.save(newStudent1);
            session.save(newStudent2);
            session.save(newStudent3);

            session.getTransaction().commit();


        }
        finally {
            factory.close();
        }


    }
}
