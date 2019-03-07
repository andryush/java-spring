package com.arakelyan.hibernate.demo.classes;

import com.arakelyan.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            /*DELETE BY ID
            session.beginTransaction();
            int studentId = 4;

            Student myStudent = session.get(Student.class, studentId);

            session.delete(myStudent);

            session.getTransaction().commit();

            //NEW CODE

            session = factory.getCurrentSession();*/

            session.beginTransaction();

            session.createQuery("delete from Student s where s.firstName like '%testName1'").executeUpdate();

            session.getTransaction().commit();

        }

        finally {
            factory.close();
        }

    }
}
