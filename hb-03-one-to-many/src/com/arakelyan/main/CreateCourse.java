package com.arakelyan.main;

import com.arakelyan.entity.Course;
import com.arakelyan.entity.Instructor;
import com.arakelyan.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourse {
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

            //get instructot from db
            int theId = 1;

            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("tempInstructor:> " + tempInstructor);

            //create some courses
            Course tempCourse1 = new Course("Spring");
            Course tempCourse2 = new Course("Hibernate");
            Course tempCourse3 = new Course("SpringBoot");

            //add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);
            tempInstructor.add(tempCourse3);


            //save instructor
            session.save(tempCourse1);
            session.save(tempCourse2);
            session.save(tempCourse3);

            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            session.close();
            factory.close();
        }

    }
}
