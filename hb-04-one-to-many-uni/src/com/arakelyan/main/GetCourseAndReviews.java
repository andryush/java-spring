package com.arakelyan.main;

import com.arakelyan.entity.Course;
import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import com.arakelyan.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviews {
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

            System.out.println("myApp Course = " + tempCourse);

            System.out.println("myApp Course Reviews = " + tempCourse.getReviews());


            session.getTransaction().commit();

            System.out.println("Done :)");



        }
        finally {
            factory.close();
        }

    }
}
