package com.arakelyan.main;

import com.arakelyan.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForAndrey1 {

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

            System.out.println("\nCourses for Andrey1:> " + tempStudent.getCourses());

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

}
