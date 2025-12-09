package com.xworkz.coreapp.internet;

import org.springframework.stereotype.Component;

@Component
public class AC {

    public AC() {
        System.out.println("AC class invoked");
    }

    private int id;
    private String name;

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "AC{id=" + id + ", name='" + name + "'}";
    }
}
