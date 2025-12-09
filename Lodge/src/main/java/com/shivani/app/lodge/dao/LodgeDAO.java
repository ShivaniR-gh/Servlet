package com.shivani.app.lodge.dao;

import com.shivani.app.lodge.dto.LodgeDTO;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface LodgeDAO {
    boolean save(LodgeDTO lodgeDTO);
    boolean isDuplicate(LodgeDTO lodgeDTO);
    default Optional<LodgeDTO> findByPhone(String phoneNumber){
        return Optional.empty();
    }

    Optional<LodgeDTO> findByPhone(long phoneNumber);
}
