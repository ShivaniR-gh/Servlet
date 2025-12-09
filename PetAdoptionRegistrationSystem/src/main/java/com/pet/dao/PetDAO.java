package com.pet.dao;

import com.pet.dto.PetAdaptionDTO;
import java.util.Optional;

public interface PetDAO {

    boolean save(PetAdaptionDTO dto) throws Exception;

    boolean isDuplicate(PetAdaptionDTO petAdaptionDTO);

    Optional<PetAdaptionDTO> findByPhone(String phone);
}
