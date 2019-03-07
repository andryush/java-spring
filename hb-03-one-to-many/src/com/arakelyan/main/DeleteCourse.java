package com.arakelyan.main;

import com.arakelyan.entity.Course;
import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {
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
            int courseId = 12;

            Course tempCourse = session.get(Course.class, courseId);

            System.out.println("The course to delete is:> " + tempCourse);

            session.delete(tempCourse);

            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }

    }
}
