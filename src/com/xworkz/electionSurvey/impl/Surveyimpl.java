package com.xworkz.electionSurvey.impl;

import com.xworkz.electionSurvey.dto.ServeyDTO;
import com.xworkz.electionSurvey.exception.DataInvalidException;
import com.xworkz.electionSurvey.service.ServeyService;

public class Surveyimpl implements ServeyService {

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

        String passportNumber = serveyDTO.getPassportNumber();
        String rationCardNumber = serveyDTO.getRationCardNumber();
        double income = serveyDTO.getIncome();
        String bankAccountNumber = serveyDTO.getBankAccountNumber();
        String fatherName = serveyDTO.getFatherName();
        String motherName = serveyDTO.getMotherName();
        String married = serveyDTO.getMarried();
        String spouseName = serveyDTO.getSpouseName();
        int numberOfChildren = serveyDTO.getNumberOfChildren();
        int numberOfCycles = serveyDTO.getNumberOfCycles();
        int numberOfFamilyMembers = serveyDTO.getNumberOfFamilyMembers();
        String insuranceCompany = serveyDTO.getInsuranceCompany();
        String insuranceNumber = serveyDTO.getInsuranceNumber();
        String laptopModel = serveyDTO.getLaptopModel();
        String tvModel = serveyDTO.getTvModel();
        double landInAcres = serveyDTO.getLandInAcres();
        int totalSites = serveyDTO.getTotalSites();
        String rtcNumber = serveyDTO.getRtcNumber();
        double taxesPaid = serveyDTO.getTaxesPaid();
        String govtEmployee = serveyDTO.getGovtEmployee();
        String disabled = serveyDTO.getDisabled();
        String caste = serveyDTO.getCaste();
        String religion = serveyDTO.getReligion();
        String motherTongue = serveyDTO.getMotherTongue();
        int age = serveyDTO.getAge();
        String dateOfBirth = serveyDTO.getDateOfBirth();
        String knownDiseases = serveyDTO.getKnownDiseases();
        double height = serveyDTO.getHeight();
        double weight = serveyDTO.getWeight();
        String complexion = serveyDTO.getComplexion();
        String bloodGroup = serveyDTO.getBloodGroup();
        int shoeSize = serveyDTO.getShoeSize();
        int numberOfShoes = serveyDTO.getNumberOfShoes();
        String friendsName = serveyDTO.getFriendsName();
        String electricityBillNumber = serveyDTO.getElectricityBillNumber();
        String waterBillNumber = serveyDTO.getWaterBillNumber();
        String buildingOwnerName = serveyDTO.getBuildingOwnerName();
        String crop = serveyDTO.getCrop();
        String loanNumber = serveyDTO.getLoanNumber();
        double loanBalance = serveyDTO.getLoanBalance();
        String loanType = serveyDTO.getLoanType();
        double goldInGrams = serveyDTO.getGoldInGrams();
        double silverInGrams = serveyDTO.getSilverInGrams();
        String petName = serveyDTO.getPetName();
        int numberOfCows = serveyDTO.getNumberOfCows();
        double shareHolding = serveyDTO.getShareHolding();


        boolean isInValid = false;

        // ★ FIRST 10 FIELDS (already written)
        if(name.length() < 3){
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
        else if (mobileNumber == 0 && mobileNumber > 1000000000){
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

        // ★ REMAINING STRING VALIDATIONS
        else if (passportNumber.length() < 3){
            isInValid = true;
        }
        else if (rationCardNumber.length() < 3){
            isInValid = true;
        }
        else if (bankAccountNumber.length() < 3){
            isInValid = true;
        }
        else if (fatherName.length() < 3){
            isInValid = true;
        }
        else if (motherName.length() < 3){
            isInValid = true;
        }
        else if (married.length() < 3){
            isInValid = true;
        }
        else if (spouseName.length() < 3){
            isInValid = true;
        }
        else if (insuranceCompany.length() < 3){
            isInValid = true;
        }
        else if (insuranceNumber.length() < 3){
            isInValid = true;
        }
        else if (laptopModel.length() < 3){
            isInValid = true;
        }
        else if (tvModel.length() < 3){
            isInValid = true;
        }
        else if (rtcNumber.length() < 3){
            isInValid = true;
        }
        else if (govtEmployee.length() < 3){
            isInValid = true;
        }
        else if (disabled.length() < 3){
            isInValid = true;
        }
        else if (caste.length() < 3){
            isInValid = true;
        }
        else if (religion.length() < 3){
            isInValid = true;
        }
        else if (motherTongue.length() < 3){
            isInValid = true;
        }
        else if (dateOfBirth.length() < 3){
            isInValid = true;
        }
        else if (knownDiseases.length() < 3){
            isInValid = true;
        }
        else if (complexion.length() < 3){
            isInValid = true;
        }
        else if (bloodGroup.length() < 1){
            isInValid = true;
        }
        else if (friendsName.length() < 3){
            isInValid = true;
        }
        else if (electricityBillNumber.length() < 3){
            isInValid = true;
        }
        else if (waterBillNumber.length() < 3){
            isInValid = true;
        }
        else if (buildingOwnerName.length() < 3){
            isInValid = true;
        }
        else if (crop.length() < 3){
            isInValid = true;
        }
        else if (loanNumber.length() < 3){
            isInValid = true;
        }
        else if (loanType.length() < 3){
            isInValid = true;
        }
        else if (petName.length() < 3){
            isInValid = true;
        }

        // ★ REMAINING NUMERIC VALIDATIONS
        else if (income == 0){
            isInValid = true;
        }
        else if (numberOfChildren < 0){
            isInValid = true;
        }
        else if (numberOfCycles < 0){
            isInValid = true;
        }
        else if (numberOfFamilyMembers < 1){
            isInValid = true;
        }
        else if (landInAcres < 0){
            isInValid = true;
        }
        else if (totalSites < 0){
            isInValid = true;
        }
        else if (taxesPaid < 0){
            isInValid = true;
        }
        else if (age <= 0){
            isInValid = true;
        }
        else if (height <= 0){
            isInValid = true;
        }
        else if (weight <= 0){
            isInValid = true;
        }
        else if (shoeSize <= 0){
            isInValid = true;
        }
        else if (numberOfShoes < 0){
            isInValid = true;
        }
        else if (loanBalance < 0){
            isInValid = true;
        }
        else if (goldInGrams < 0){
            isInValid = true;
        }
        else if (silverInGrams < 0){
            isInValid = true;
        }
        else if (numberOfCows < 0){
            isInValid = true;
        }
        else if (shareHolding < 0){
            isInValid = true;
        }

        if(isInValid){
            throw new DataInvalidException("Invalid data has been added");
        }

        System.out.println("All data is valid, ready to save: " + serveyDTO);
    }
}
