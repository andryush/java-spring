package com.example.rbc.validator;

import com.example.rbc.model.User;
import com.example.rbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PasswordValidator implements Validator {

    private final UserService userService;

    @Autowired
    public PasswordValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 3 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userPasswordForm.password");
        }


    }
}
