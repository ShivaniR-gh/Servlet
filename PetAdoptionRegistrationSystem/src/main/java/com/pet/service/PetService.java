package com.pet.service;

import com.pet.dto.PetAdaptionDTO;
import com.pet.exception.DataInvalidException;

public interface PetService {
    boolean validate(PetAdaptionDTO petAdaptionDTO) throws DataInvalidException;
}
