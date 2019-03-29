package com.arakelyan.jackson.jason.databinding;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try {

            //create object mapper(Jackson)
            ObjectMapper mapper = new ObjectMapper();

            //read JSON file and convert/map to JAVA POJO. file /data/sample-lite.json
            Student theStudent =
                    mapper.readValue(new File("data/sample-full.json"), Student.class);

            //print the first name and the last name
            System.out.println("First name " + theStudent.getFirstName() + ", " + "last name " + theStudent.getLastName());

            //print out address (street and city)
            Address myAddress = theStudent.getAddress();

            System.out.println("Street = " + myAddress.getStreet());
            System.out.println("City = " + myAddress.getCity());

            //print languages
            for (String tempLanguages : theStudent.getLanguages()) {
                System.out.println(tempLanguages);
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

}
