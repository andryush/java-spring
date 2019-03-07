package com.arakelyan.main;

import com.arakelyan.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForAndrey1 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            //get student Andrey1 from db
            int theId = 1;
            Student tempStudent = session.get(Student.class, theId);
            System.out.println("\nSelected student is :> " + tempStudent);

            //create more courses
            Course tempCourse1 = new Course("Spring & Hibernate");
            Course tempCourse2 = new Course("Spring boot");

            //add Andrey1 to these courses
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);


            //saving courses
            System.out.println("\nSaving courses:> ");
            session.save(tempCourse1);
            session.save(tempCourse2);

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

}
