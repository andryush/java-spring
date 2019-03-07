package com.arakelyan.main;

import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            //create objects
            Instructor tempInstructor =
                    new Instructor("aaa", "sss", "andrey1@arakelyan.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("myChannel1", "coding1");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //begin transaction
            session.beginTransaction();

            //save the instructor
            System.out.println("Saving the instructor: " + tempInstructor);
            session.save(tempInstructor);

            //commit changes
            session.getTransaction().commit();

        }

        finally {
            factory.close();
        }

    }
}
