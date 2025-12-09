package com.xworkz.coreapp.internet;

import org.springframework.stereotype.Component;

@Component
public class Internet {
    Internet(){
        System.out.println("Internet class invoked");
    }
    private int internetId;
    private String name;

    public void setInternetId(int internetId) {
        this.internetId = internetId;
    }

    public int getInternetId() {
        return internetId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Internet{" +
                "internetId=" + internetId +
                ", name='" + name + '\'' +
                '}';
    }
}
