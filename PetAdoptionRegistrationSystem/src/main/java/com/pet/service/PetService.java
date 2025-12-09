package com.pet.service;

import com.pet.dto.PetAdaptionDTO;
import com.pet.dto.SearchDTO;
import com.pet.exception.DataInvalidException;
import java.sql.SQLException;
import java.util.Optional;

public interface PetService {
    boolean validateAndSave(PetAdaptionDTO dto) throws Exception;
    default Optional<PetAdaptionDTO> findByPhone (SearchDTO searchDTO){
        return  Optional.empty();
    }
}
