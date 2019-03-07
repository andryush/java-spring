package com.arakelyan.hibernate.demo.classes;

import com.arakelyan.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CRUDEmployee {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            //Creating employers
            session.beginTransaction();

            Employee addedEmployee = new Employee("Andrey", "Arakelyan", "Home");
            Employee addedEmployee1 = new Employee("Andrey1", "Arakelyan1", "Home");
            Employee addedEmployee2 = new Employee("John", "Doe", "Home");

            session.save(addedEmployee);
            session.save(addedEmployee1);
            session.save(addedEmployee2);

            session.getTransaction().commit();


            //Reading employers
            session = factory.getCurrentSession();

            session.beginTransaction();

            //By ID
//            Employee byIdEmployee = session.get(Employee.class, addedEmployee2.getId());
//            System.out.println(byIdEmployee);

            //by Query
            List<Employee> employersQuery = session.createQuery("from Employee s where s.company='Home'").getResultList();

            for(Employee tempEmployee: employersQuery ) {
                System.out.println(tempEmployee);

            }


            session.getTransaction().commit();


            //Deleting employers
            session = factory.getCurrentSession();

            session.beginTransaction();

            session.createQuery("delete from Employee where id='3'").executeUpdate();

            session.getTransaction().commit();


        }

        finally {
            factory.close();
        }

    }
}
