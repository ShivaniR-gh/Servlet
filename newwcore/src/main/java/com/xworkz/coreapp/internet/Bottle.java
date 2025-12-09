package com.xworkz.coreapp.internet;

import org.springframework.stereotype.Component;

@Component
public class Bottle {

    public Bottle() {
        System.out.println("Bottle class invoked");
    }

    private int id;
    private String name;

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Bottle{id=" + id + ", name='" + name + "'}";
    }
}
