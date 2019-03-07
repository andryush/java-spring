package com.arakelyan.main;

import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            //get InstructorDetail object by id
            int id = 7;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            //print associated instructor
            System.out.println("Associated instructor: " + tempInstructorDetail.getInstructor());

            //breaking bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            //Delete tempInstructorDetail object (cascade delete associated instructor)
            session.delete(tempInstructorDetail);

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
