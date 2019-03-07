package com.arakelyan.main;

import com.arakelyan.entity.Course;
import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import com.arakelyan.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviews {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            int theId = 10;

            Course tempCourse = session.get(Course.class, theId);

            System.out.println("myAPP: > Course = " + tempCourse);
            System.out.println("myAPP: > Course reviews = " + tempCourse.getReviews());

            System.out.println("myAPP: > Deleting course and reviews .:.:.:.:.");

            session.delete(tempCourse);



            session.getTransaction().commit();

            System.out.println("Done :)");



        }
        finally {
            factory.close();
        }

    }
}
