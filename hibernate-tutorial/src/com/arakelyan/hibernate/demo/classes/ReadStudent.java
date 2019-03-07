package com.arakelyan.hibernate.demo.classes;

import com.arakelyan.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student testStudent = new Student("testName1", "testName1", "testEmail1");

            session.beginTransaction();

            System.out.println("Saving the student:");
            System.out.println(testStudent);
            session.save(testStudent);

            session.getTransaction().commit();


            //find out students id: primary key
            System.out.println("Saved student Generated ID: " + testStudent.getId());

            //get new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on id:
            System.out.println("\nGetting student with id: " + testStudent.getId());
            Student myStudent = session.get(Student.class, testStudent.getId());

            System.out.println("Get complete: " + myStudent);

            //commit transaction
            session.getTransaction().commit();

        }
        finally {
            session.close();
        }

    }
}
