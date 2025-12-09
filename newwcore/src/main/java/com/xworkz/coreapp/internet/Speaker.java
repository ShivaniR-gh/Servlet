package com.xworkz.coreapp.internet;

import org.springframework.stereotype.Component;

@Component
public class Speaker {

    public Speaker() {
        System.out.println("Speaker class invoked");
    }

    private int id;
    private String name;

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Speaker{id=" + id + ", name='" + name + "'}";
    }
}
