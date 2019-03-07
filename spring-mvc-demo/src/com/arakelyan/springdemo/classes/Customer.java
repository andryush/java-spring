package com.arakelyan.springdemo.classes;

import com.arakelyan.springdemo.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0,message = "must be greater then or equal to 0")
    @Max(value = 10, message = "must be less then or equal to 10")
    private Integer numberOfPasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only five digits/chars")
    private String postalCode;

    @CourseCode(value = "TOPS", message = "must start with TOPS")
    private String courseCode;

    public Customer() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfPasses() {
        return numberOfPasses;
    }

    public void setNumberOfPasses(Integer numberOfPasses) {
        this.numberOfPasses = numberOfPasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
