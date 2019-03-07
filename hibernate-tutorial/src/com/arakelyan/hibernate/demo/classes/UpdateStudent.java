package com.arakelyan.hibernate.demo.classes;

import com.arakelyan.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();

            Student newStudent = session.get(Student.class, studentId);
            newStudent.setFirstName("and");

            session.getTransaction().commit();

            //NEW CODE
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student s set s.eMail='123@456' where s.eMail like '%@arakelyan.com'").executeUpdate();

            session.getTransaction().commit();

        }

        finally {
            factory.close();
        }

    }
}
