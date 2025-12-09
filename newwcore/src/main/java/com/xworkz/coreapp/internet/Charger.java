package com.xworkz.coreapp.internet;

import org.springframework.stereotype.Component;

@Component
public class Charger {

    public Charger() {
        System.out.println("Charger class invoked");
    }

    private int id;
    private String name;

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Charger{id=" + id + ", name='" + name + "'}";
    }
}
