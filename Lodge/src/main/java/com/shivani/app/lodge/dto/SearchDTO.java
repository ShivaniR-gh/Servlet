package com.shivani.app.lodge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SearchDTO {
    private long phoneNumber;

    @Override
    public String toString() {
        return "SearchDTO{" +
                "phoneNumber=" + phoneNumber +
                '}';
    }
}
