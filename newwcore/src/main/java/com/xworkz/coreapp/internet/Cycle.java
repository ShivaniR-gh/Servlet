package com.xworkz.coreapp.internet;

import org.springframework.stereotype.Component;

@Component
public class Cycle {

    public Cycle() {
        System.out.println("Cycle class invoked");
    }

    private int id;
    private String name;

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Cycle{id=" + id + ", name='" + name + "'}";
    }
}
