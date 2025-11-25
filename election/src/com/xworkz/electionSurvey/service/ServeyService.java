package com.xworkz.electionSurvey.service;

import com.xworkz.electionSurvey.dto.ServeyDTO;
import com.xworkz.electionSurvey.exception.DataInvalidException;

public interface ServeyService {
    void ValidateAndSave(ServeyDTO serveyDTO) throws DataInvalidException;
}
