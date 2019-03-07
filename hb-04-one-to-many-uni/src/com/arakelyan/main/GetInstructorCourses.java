package com.arakelyan.main;

import com.arakelyan.entity.Course;
import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourses {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 1;

            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("The instructor:> " + tempInstructor);

            System.out.println("Courses:> " + tempInstructor.getCourses());

            session.getTransaction().commit();


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
