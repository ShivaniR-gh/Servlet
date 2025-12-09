package com.shivani.app.lodge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LodgeDTO implements Serializable {
    private String name;
    private long phoneNumber;
    private String roomType;
    private double totalAmount;
    private String paymentStatus;


    @Override
    public String toString() {
        return "LodgeDTO{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", room='" + roomType + '\'' +
                ", totalAmount=" + totalAmount +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
