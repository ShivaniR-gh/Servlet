package org.example;

public class LaunchApp {
    public static void main(String[] args) {
        TShapedSkills tShapedSkills = new TShapedSkills( new SpringBoot());

//        ICourse  iCourse = new Java();
//        tShapedSkills.setCourse(iCourse);

        tShapedSkills.setCourse(new Java());
        //tShapedSkills.setCourse(new SpringBoot());
        Boolean status = tShapedSkills.getCourse(4999.4);
        if (status){
            System.out.println("Success");
        }
        else {
            System.out.println("Not Bought");
        }
    }
}
