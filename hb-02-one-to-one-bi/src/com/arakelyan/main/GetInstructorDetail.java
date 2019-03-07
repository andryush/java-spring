package com.arakelyan.main;

import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetail {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {


            session.beginTransaction();

            int theId = 333;

            //get instructor detail object by id
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            //print instructor detail object
            System.out.println("instructor detail object: " + tempInstructorDetail);

            //print associated instructor
            System.out.println("associated instructor: " + tempInstructorDetail.getInstructor());


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
