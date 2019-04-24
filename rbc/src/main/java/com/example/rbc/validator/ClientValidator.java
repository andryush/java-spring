package com.example.rbc.validator;

import com.example.rbc.model.Client;
import com.example.rbc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ClientValidator implements Validator {

    private final ClientService clientService;

    @Autowired
    public ClientValidator(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Client client = (Client) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Required");

        if (client.getFirstName().length() < 2 || client.getFirstName().length() > 32) {
            errors.rejectValue("firstName", "Size.clientForm.firstName");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Required");

        if (client.getLastName().length() < 2 || client.getLastName().length() > 32) {
            errors.rejectValue("lastName", "Size.clientForm.lastName");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");

        if (client.getEmail().length() < 6 || client.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.clientForm.email");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "Required");

        if (client.getPhone().length() < 2 || client.getPhone().length() > 32) {
            errors.rejectValue("phone", "Size.clientForm.phone");
        }


    }
}
