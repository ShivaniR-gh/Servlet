package org.example;

public class Java implements ICourse {


    @Override
    public Boolean getTheCourses(Double price) {
        System.out.println("Java course has been purchased " + price);
        return true;
    }

}
