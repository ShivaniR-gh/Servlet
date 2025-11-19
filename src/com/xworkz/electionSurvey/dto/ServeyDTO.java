package com.xworkz.electionSurvey.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class ServeyDTO implements Serializable, Comparable<String> {

    private String name;
    private String occupation;
    private String education;
    private String nativePlace;
    private String bikeNumber;
    private String carNumber;
    private long mobileNumber;
    private long aadharNumber;
    private String panCardNumber;
    private long voterIDNumber;

    private String passportNumber;
    private String rationCardNumber;
    private double income;
    private String bankAccountNumber;
    private String fatherName;
    private String motherName;
    private String married;
    private String spouseName;
    private int numberOfChildren;
    private int numberOfCycles;
    private int numberOfFamilyMembers;
    private String insuranceCompany;
    private String insuranceNumber;
    private String laptopModel;
    private String tvModel;
    private double landInAcres;
    private int totalSites;
    private String rtcNumber;
    private double taxesPaid;
    private String govtEmployee;
    private String disabled;
    private String caste;
    private String religion;
    private String motherTongue;
    private int age;
    private String dateOfBirth;
    private String knownDiseases;
    private double height;
    private double weight;
    private String complexion;
    private String bloodGroup;
    private int shoeSize;
    private int numberOfShoes;
    private String friendsName;
    private String electricityBillNumber;
    private String waterBillNumber;
    private String buildingOwnerName;
    private String crop;
    private String loanNumber;
    private double loanBalance;
    private String loanType;
    private double goldInGrams;
    private double silverInGrams;
    private String petName;
    private int numberOfCows;
    private double shareHolding;


    @Override
    public String toString() {
        return "ServeyDTO{" +
                "name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", education='" + education + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", bikeNumber='" + bikeNumber + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", aadharNumber=" + aadharNumber +
                ", panCardNumber='" + panCardNumber + '\'' +
                ", voterIDNumber=" + voterIDNumber +
                ", passportNumber='" + passportNumber + '\'' +
                ", rationCardNumber='" + rationCardNumber + '\'' +
                ", income=" + income +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", married='" + married + '\'' +
                ", spouseName='" + spouseName + '\'' +
                ", numberOfChildren=" + numberOfChildren +
                ", numberOfCycles=" + numberOfCycles +
                ", numberOfFamilyMembers=" + numberOfFamilyMembers +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", laptopModel='" + laptopModel + '\'' +
                ", tvModel='" + tvModel + '\'' +
                ", landInAcres=" + landInAcres +
                ", totalSites=" + totalSites +
                ", rtcNumber='" + rtcNumber + '\'' +
                ", taxesPaid=" + taxesPaid +
                ", govtEmployee='" + govtEmployee + '\'' +
                ", disabled='" + disabled + '\'' +
                ", caste='" + caste + '\'' +
                ", religion='" + religion + '\'' +
                ", motherTongue='" + motherTongue + '\'' +
                ", age=" + age +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", knownDiseases='" + knownDiseases + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", complexion='" + complexion + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", shoeSize=" + shoeSize +
                ", numberOfShoes=" + numberOfShoes +
                ", friendsName='" + friendsName + '\'' +
                ", electricityBillNumber='" + electricityBillNumber + '\'' +
                ", waterBillNumber='" + waterBillNumber + '\'' +
                ", buildingOwnerName='" + buildingOwnerName + '\'' +
                ", crop='" + crop + '\'' +
                ", loanNumber='" + loanNumber + '\'' +
                ", loanBalance=" + loanBalance +
                ", loanType='" + loanType + '\'' +
                ", goldInGrams=" + goldInGrams +
                ", silverInGrams=" + silverInGrams +
                ", petName='" + petName + '\'' +
                ", numberOfCows=" + numberOfCows +
                ", shareHolding=" + shareHolding +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name, occupation, education, nativePlace, bikeNumber, carNumber, mobileNumber, aadharNumber,
                panCardNumber, voterIDNumber, passportNumber, rationCardNumber, income, bankAccountNumber,
                fatherName, motherName, married, spouseName, numberOfChildren, numberOfCycles,
                numberOfFamilyMembers, insuranceCompany, insuranceNumber, laptopModel, tvModel, landInAcres,
                totalSites, rtcNumber, taxesPaid, govtEmployee, disabled, caste, religion, motherTongue, age,
                dateOfBirth, knownDiseases, height, weight, complexion, bloodGroup, shoeSize, numberOfShoes,
                friendsName, electricityBillNumber, waterBillNumber, buildingOwnerName, crop, loanNumber,
                loanBalance, loanType, goldInGrams, silverInGrams, petName, numberOfCows, shareHolding
        );
    }

    @Override
    public int compareTo(String o) {
        return this.name.compareTo(o);
    }
}
