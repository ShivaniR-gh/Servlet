package org.example;

public enum DBConstant {

    URL("jdbc:mysql://localhost:3306/sweet"),
    USERNAME("root"),
    SECRET("Shivani@2025");

    private String s;
    DBConstant(String s) {
        this.s = s;
        System.out.println("Running DB");
    }

    public String getS() {
        return s;
    }
}
