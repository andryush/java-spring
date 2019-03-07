package com.arakelyan.main;

import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();

            session.beginTransaction();

            //get instructor by id
            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class, id);
            System.out.println("Found the instructor: " + tempInstructor);


            //delete instructor by id
            if(tempInstructor != null) {
                System.out.println("Deleting: " + tempInstructor);
                session.delete(tempInstructor);
            }
            else {
                System.out.println("***Null***");
            }

            //delete by query
            //session.createQuery("delete from Instructor s where s.id='3'").executeUpdate();

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }
}
