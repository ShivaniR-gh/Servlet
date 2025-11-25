package com.xworkz.electionSurvey.dto.impl;

import com.xworkz.electionSurvey.dao.SurveyDAO;
import com.xworkz.electionSurvey.dao.impl.SurveyDAOimpl;
import com.xworkz.electionSurvey.dto.ServeyDTO;
import com.xworkz.electionSurvey.exception.DataInvalidException;
import com.xworkz.electionSurvey.service.ServeyService;

public class Surveyimpl implements ServeyService {

    private  final SurveyDAO surveyDAO = new SurveyDAOimpl();
    @Override
    public void ValidateAndSave(ServeyDTO serveyDTO) throws DataInvalidException {

        System.out.println("Validation Integration.......");

        String name = serveyDTO.getName();
        String occupation = serveyDTO.getOccupation();
        String education = serveyDTO.getEducation();
        String nativePlace = serveyDTO.getNativePlace();
        String bikeNumber = serveyDTO.getBikeNumber();
        String carNumber = serveyDTO.getCarNumber();
        long mobileNumber = serveyDTO.getMobileNumber();
        long adharNumber = serveyDTO.getAadharNumber();
        String panCardNumber = serveyDTO.getPanCardNumber();
        long voterIDNumber = serveyDTO.getVoterIDNumber();



        boolean isInValid = false;

        if(name == null || name.length() < 3) {
            isInValid = true;
        }
        else if (occupation.length() < 3){
            isInValid = true;
        }
        else if (education.length() < 3){
            isInValid = true;
        }
        else if (nativePlace.length() < 3){
            isInValid = true;
        }
        else if (bikeNumber.length() < 3){
            isInValid = true;
        }
        else if (carNumber.length() < 3){
            isInValid = true;
        }
        else if(mobileNumber <= 0 || mobileNumber > 99999999){
            isInValid = true;
        }
        else if (adharNumber == 0 && adharNumber > 1000000000){
            isInValid = true;
        }
        else if (panCardNumber.length() < 3){
            isInValid = true;
        }
        else if (voterIDNumber == 0 && voterIDNumber > 1000000000){
            isInValid = true;
        }




        if(isInValid){
            throw new DataInvalidException("Invalid data has been added");
        }else {
           boolean saved = surveyDAO.save(serveyDTO);
            System.out.println("The data is valid successfully " +saved);
        }

        System.out.println("All data is valid, ready to save: " + serveyDTO);
    }
}
