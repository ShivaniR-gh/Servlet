package com.pet.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetAdaptionDTO {
    private String name;
    private String city;
    private String petType;
    private int experience;
    private String phone;
}
