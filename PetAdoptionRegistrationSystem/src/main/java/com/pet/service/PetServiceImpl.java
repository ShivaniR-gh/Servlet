package com.pet.service;

import com.pet.dto.PetAdaptionDTO;
import com.pet.exception.DataInvalidException;

public class PetServiceImpl implements PetService{
    @Override
    public boolean validate(PetAdaptionDTO petAdaptionDTO) throws DataInvalidException {
        if(petAdaptionDTO.getName().length() < 3) return false;
        if(petAdaptionDTO.getCity().length() < 3) return false;
        if(petAdaptionDTO.getExperience() < 0 ) return  false;
        if(!petAdaptionDTO.getPhone().matches("\\d{10}")) return  false;
        if(!petAdaptionDTO.getPetType().matches("Dog|Cat|Rabbit"))return false;
        return  true;
    }
}
