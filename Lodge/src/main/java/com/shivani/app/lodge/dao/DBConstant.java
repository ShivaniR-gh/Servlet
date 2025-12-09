package com.shivani.app.lodge.dao;

public enum DBConstant {
    URL("jdbc:mysql://localhost:3306/lodge_db"),
    USERNAME("root"),
    PASSWORD("Shivani@2025");

    private String s;
    DBConstant(String s) {
        this.s = s;
        System.out.println("Running the database");
    }

    public String getS() {
        return s;
    }
}
