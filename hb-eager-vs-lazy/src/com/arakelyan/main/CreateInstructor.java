package com.arakelyan.main;

import com.arakelyan.entity.Course;
import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
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

            //Creating objects
            Instructor instructor = new Instructor("Andrey1", "Arakelyan1", "andrey1@arakelyan.com");
            InstructorDetail instructorDetail = new InstructorDetail("mychannel1", "codding1");

            instructor.setInstructorDetail(instructorDetail);

            //Saving objects to db
            session.save(instructor);

            session.getTransaction().commit();

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        finally {
            session.close();
            factory.close();
        }

    }
}
