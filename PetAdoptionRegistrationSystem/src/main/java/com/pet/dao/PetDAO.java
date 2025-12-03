package com.pet.dao;

import com.pet.dto.PetAdaptionDTO;

import java.sql.SQLException;

public interface PetDAO {
    boolean save(PetAdaptionDTO petAdaptionDTO) throws SQLException;
}
