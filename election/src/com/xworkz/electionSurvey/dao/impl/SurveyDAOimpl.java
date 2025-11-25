package com.xworkz.electionSurvey.dao.impl;

import com.xworkz.electionSurvey.dao.SurveyDAO;
import com.xworkz.electionSurvey.dto.ServeyDTO;

public class SurveyDAOimpl implements SurveyDAO {
    public  SurveyDAOimpl(){
        System.out.println("Survey Object created");
    }
    @Override
    public boolean save(ServeyDTO serveyDTO) {
        return false;
    }
}
