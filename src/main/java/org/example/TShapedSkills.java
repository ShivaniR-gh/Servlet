package org.example;

public class TShapedSkills {

    private ICourse course;
    public  TShapedSkills( ICourse course){
        super();
        this.course=course;
    }
    public  TShapedSkills(){

    }
    public void setCourse(ICourse course){
        this.course = course;
    }

    public Boolean getCourse(Double amount){
        return course.getTheCourses(amount);
    }
}


