package com.arakelyan.main;

import com.arakelyan.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteSpringBootCourse {

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

            //getting course from db
            int theId = 12;

            Course tempCourse = session.get(Course.class, theId);
            System.out.println("\nCourse selected:> " + tempCourse);

            System.out.println("\nDeleting the course...\n");
            session.delete(tempCourse);


            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

}
