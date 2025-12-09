package com.shivani.app.lodge.service;

import com.shivani.app.lodge.dto.LodgeDTO;
import com.shivani.app.lodge.dto.SearchDTO;
import com.shivani.app.lodge.exception.DataDuplicateException;
import com.shivani.app.lodge.exception.DataInvalidException;

import java.util.Optional;

public interface LodgeService {
    boolean validateAndSave(LodgeDTO lodgeDTO) throws DataInvalidException , DataDuplicateException;
    default Optional<LodgeDTO> findByPhoneNumber(SearchDTO searchDTO){
        return Optional.empty();
    }

    Optional<LodgeDTO> findByPhone(SearchDTO searchDTO);
}
