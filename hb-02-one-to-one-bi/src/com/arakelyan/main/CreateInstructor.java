package com.arakelyan.main;

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
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Instructor newInstructor = new Instructor("Andrey4", "Arakelyan4", "andrey4@arakelyan.com");
            InstructorDetail newInstructorDetail = new InstructorDetail("myChannel", "codding");

            newInstructor.setInstructorDetail(newInstructorDetail);

            session.save(newInstructor);

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }


    }
}
