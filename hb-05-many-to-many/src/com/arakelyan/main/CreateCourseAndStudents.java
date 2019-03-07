package com.arakelyan.main;

import com.arakelyan.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudents {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Course tempCourse = new Course("Spring: Beginning");

            //Save the course
            System.out.println("\nSaving the course\n");
            session.save(tempCourse);
            System.out.println("\nSaved the course:> " + tempCourse);

            //create the students
            Student tempStudent1 = new Student("Andrey1", "Arakelyan1", "andrey1@arakelyan.com");
            Student tempStudent2 = new Student("Andrey2", "Arakelyan2", "andrey2@arakelyan.com");

            //add students to the course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            //save students
            System.out.println("\nSaving students... \n");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("\nSaved students:> " + tempCourse.getStudents());


            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

}
