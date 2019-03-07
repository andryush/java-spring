package com.arakelyan.main;

import com.arakelyan.entity.Course;
import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoin {
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

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i " +
                            "JOIN FETCH i.courses " +
                            "where i.id=:theInstructorId", Instructor.class);

            query.setParameter("theInstructorId", theId);

            Instructor tempInstructor = query.getSingleResult();

            System.out.println("myAPP|| Instructor: " + tempInstructor);

            session.getTransaction().commit();

            session.close();

            System.out.println("\nThe session was closed!\n");

            System.out.println("myApp|| Courses: " + tempInstructor.getCourses());

            System.out.println("myApp|| done");

        }

        finally {
            factory.close();
        }


    }
}
