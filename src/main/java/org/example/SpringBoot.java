package org.example;

public class SpringBoot implements ICourse{
    @Override
    public Boolean getTheCourses(Double price) {
        System.out.println("The Spring course has been purchased successfullly " + price);
        return true;
    }
}
