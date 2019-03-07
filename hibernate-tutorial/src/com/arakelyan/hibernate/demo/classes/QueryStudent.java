package com.arakelyan.hibernate.demo.classes;

import com.arakelyan.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    //Display students from query method
    private static void displayStudents(List<Student> studentsQuery) {
        for (Student tempStudent: studentsQuery) {
            System.out.println(tempStudent);
        }
    }

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //begin transaction
            session.beginTransaction();


            //query students
            List<Student> studentsQuery = session.createQuery("from Student").getResultList();

            //display students
            displayStudents(studentsQuery);


            //query students with last name Arakelyan3
            studentsQuery = session.createQuery("from Student s where s.lastName='Arakelyan3'").getResultList();

            //display students with last name Arakelyan3
            displayStudents(studentsQuery);


            //query students with last name Arakelyan5 OR first name testName1
            studentsQuery = session.createQuery
                    ("from Student s where s.lastName='Arakelyan5' OR s.firstName='testname1'").getResultList();

            //display stdunets with last name Arakelyan5 OR first name testName1
            System.out.println("\n\n\n");
            displayStudents(studentsQuery);



            //query students with email like @arakelyan.com
            studentsQuery = session.createQuery("from Student s where s.eMail LIKE '%@arakelyan.com'").getResultList();

            //display students with email like @arakelyan.com
            System.out.println("\n\n\n\n");
            displayStudents(studentsQuery);

            //commit transaction
            session.getTransaction().commit();

        }

        finally {
            factory.close();
        }

    }

}
