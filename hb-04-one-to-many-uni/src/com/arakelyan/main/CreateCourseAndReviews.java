package com.arakelyan.main;

import com.arakelyan.entity.Course;
import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import com.arakelyan.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviews {
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

            Course tempCourse = new Course("SpringBoot");

            Review review1 = new Review("Nice course");
            Review review2 = new Review("Really cool");
            Review review3 = new Review("Nice work ;)");

            tempCourse.addReview(review1);
            tempCourse.addReview(review2);
            tempCourse.addReview(review3);

            session.save(tempCourse);
            System.out.println("Course is : > " + tempCourse);
            System.out.println("Reviews : > " + tempCourse.getReviews());

            session.getTransaction().commit();

            System.out.println("Done :)");



        }
        finally {
            factory.close();
        }

    }
}
