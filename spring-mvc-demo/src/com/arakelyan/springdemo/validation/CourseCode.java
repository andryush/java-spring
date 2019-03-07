package com.arakelyan.springdemo.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //Define default course code
    String value() default "AND";

    //Define default error message
    String message() default "must start with AND";

    //Define default groups
    Class<?>[] groups() default {};

    //Define default payloads
    Class<? extends Payload>[] payload() default {};
}
