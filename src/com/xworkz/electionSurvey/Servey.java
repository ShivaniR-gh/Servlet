package com.xworkz.electionSurvey;

import com.xworkz.electionSurvey.dto.ServeyDTO;
import com.xworkz.electionSurvey.exception.DataInvalidException;
import com.xworkz.electionSurvey.impl.Surveyimpl;
import com.xworkz.electionSurvey.service.ServeyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/survey" , loadOnStartup = 1)

public class Servey extends HttpServlet {

    private  final ServeyService service = new Surveyimpl();
    public Servey(){
        System.out.println("Survey object created");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("Text/html");

        String name =req.getParameter("name");
        String occupation= req.getParameter("occupation");
        String education=req.getParameter("education");
        String nativePlace= req.getParameter("nativePlace");
        String bikeNumber = req.getParameter("bikeNumber");
        String carNumber=req.getParameter("carNumber");
        String mobileNumber= req.getParameter("mobileNumber");
        String aadharNumber=req.getParameter("aadharNumber");
        String panCardNumber=req.getParameter("panCardNumber");
        String voterIDNumber= req.getParameter("voterIDNumber");
        String passportNumber = req.getParameter("passportNumber");
        String rationCardNumber = req.getParameter("rationCardNumber");
        String income = req.getParameter("income");
        String bankAccountNumber = req.getParameter("bankAccountNumber");
        String fatherName = req.getParameter("fatherName");
        String motherName = req.getParameter("motherName");
        String married = req.getParameter("married");
        String spouseName = req.getParameter("spouseName");
        String numberOfChildren = req.getParameter("numberOfChildren");
        String numberOfCycles = req.getParameter("numberOfCycles");
        String numberOfFamilyMembers = req.getParameter("numberOfFamilyMembers");
        String insuranceCompany = req.getParameter("insuranceCompany");
        String insuranceNumber = req.getParameter("insuranceNumber");
        String laptopModel = req.getParameter("laptopModel");
        String tvModel = req.getParameter("tvModel");
        String landInAcres = req.getParameter("landInAcres");
        String totalSites = req.getParameter("totalSites");
        String rtcNumber = req.getParameter("rtcNumber");
        String taxesPaid = req.getParameter("taxesPaid");
        String govtEmployee = req.getParameter("govtEmployee");
        String disabled = req.getParameter("disabled");
        String caste = req.getParameter("caste");
        String religion = req.getParameter("religion");
        String motherTongue = req.getParameter("motherTongue");
        String age = req.getParameter("age");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String knownDiseases = req.getParameter("knownDiseases");
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");
        String complexion = req.getParameter("complexion");
        String bloodGroup = req.getParameter("bloodGroup");
        String shoeSize = req.getParameter("shoeSize");
        String numberOfShoes = req.getParameter("numberOfShoes");
        String friendsName = req.getParameter("friendsName");
        String electricityBillNumber = req.getParameter("electricityBillNumber");
        String waterBillNumber = req.getParameter("waterBillNumber");
        String buildingOwnerName = req.getParameter("buildingOwnerName");
        String crop = req.getParameter("crop");
        String loanNumber = req.getParameter("loanNumber");
        String loanBalance = req.getParameter("loanBalance");
        String loanType = req.getParameter("loanType");
        String goldInGrams = req.getParameter("goldInGrams");
        String silverInGrams = req.getParameter("silverInGrams");
        String petName = req.getParameter("petName");
        String numberOfCows = req.getParameter("numberOfCows");
        String shareHolding = req.getParameter("shareHolding");


        ServeyDTO serveyDTO = new ServeyDTO(
                name, occupation, education, nativePlace, bikeNumber, carNumber,
                Long.parseLong(mobileNumber), Long.parseLong(aadharNumber), panCardNumber,
                Long.parseLong(voterIDNumber),
                passportNumber, rationCardNumber, Double.parseDouble(income), bankAccountNumber,
                fatherName, motherName, married, spouseName, Integer.parseInt(numberOfChildren),
                Integer.parseInt(numberOfCycles), Integer.parseInt(numberOfFamilyMembers),
                insuranceCompany, insuranceNumber, laptopModel, tvModel,
                Double.parseDouble(landInAcres), Integer.parseInt(totalSites), rtcNumber,
                Double.parseDouble(taxesPaid), govtEmployee, disabled, caste, religion,
                motherTongue, Integer.parseInt(age), dateOfBirth, knownDiseases,
                Double.parseDouble(height), Double.parseDouble(weight), complexion,
                bloodGroup, Integer.parseInt(shoeSize), Integer.parseInt(numberOfShoes),
                friendsName, electricityBillNumber, waterBillNumber, buildingOwnerName,
                crop, loanNumber, Double.parseDouble(loanBalance), loanType,
                Double.parseDouble(goldInGrams), Double.parseDouble(silverInGrams),
                petName, Integer.parseInt(numberOfCows), Double.parseDouble(shareHolding)
        );

        System.out.println(serveyDTO.toString());



        try {
            service.ValidateAndSave(serveyDTO);
            req.setAttribute("successMessage","The data is Valid so saved successfully");
        } catch (DataInvalidException e) {
            req.setAttribute("errorMessage" , "The data is invalid please add the valid data");
            req.getRequestDispatcher("SurveyResult.jsp").forward(req,resp);
             return; // stop further processing
        }

        req.setAttribute("name", name);
        req.setAttribute("occupation", occupation);
        req.setAttribute("education", education);
        req.setAttribute("nativePlace", nativePlace);
        req.setAttribute("bikeNumber", bikeNumber);
        req.setAttribute("carNumber", carNumber);
        req.setAttribute("mobileNumber", mobileNumber);
        req.setAttribute("aadharNumber", aadharNumber);
        req.setAttribute("panCardNumber", panCardNumber);
        req.setAttribute("voterIDNumber", voterIDNumber);
        req.setAttribute("passportNumber", passportNumber);
        req.setAttribute("rationCardNumber", rationCardNumber);
        req.setAttribute("income", income);
        req.setAttribute("bankAccountNumber", bankAccountNumber);
        req.setAttribute("fatherName", fatherName);
        req.setAttribute("motherName", motherName);
        req.setAttribute("married", married);
        req.setAttribute("spouseName", spouseName);
        req.setAttribute("numberOfChildren", numberOfChildren);
        req.setAttribute("numberOfCycles", numberOfCycles);
        req.setAttribute("numberOfFamilyMembers", numberOfFamilyMembers);
        req.setAttribute("insuranceCompany", insuranceCompany);
        req.setAttribute("insuranceNumber", insuranceNumber);
        req.setAttribute("laptopModel", laptopModel);
        req.setAttribute("tvModel", tvModel);
        req.setAttribute("landInAcres", landInAcres);
        req.setAttribute("totalSites", totalSites);
        req.setAttribute("rtcNumber", rtcNumber);
        req.setAttribute("taxesPaid", taxesPaid);
        req.setAttribute("govtEmployee", govtEmployee);
        req.setAttribute("disabled", disabled);
        req.setAttribute("caste", caste);
        req.setAttribute("religion", religion);
        req.setAttribute("motherTongue", motherTongue);
        req.setAttribute("age", age);
        req.setAttribute("dateOfBirth", dateOfBirth);
        req.setAttribute("knownDiseases", knownDiseases);
        req.setAttribute("height", height);
        req.setAttribute("weight", weight);
        req.setAttribute("complexion", complexion);
        req.setAttribute("bloodGroup", bloodGroup);
        req.setAttribute("shoeSize", shoeSize);
        req.setAttribute("numberOfShoes", numberOfShoes);
        req.setAttribute("friendsName", friendsName);
        req.setAttribute("electricityBillNumber", electricityBillNumber);
        req.setAttribute("waterBillNumber", waterBillNumber);
        req.setAttribute("buildingOwnerName", buildingOwnerName);
        req.setAttribute("crop", crop);
        req.setAttribute("loanNumber", loanNumber);
        req.setAttribute("loanBalance", loanBalance);
        req.setAttribute("loanType", loanType);
        req.setAttribute("goldInGrams", goldInGrams);
        req.setAttribute("silverInGrams", silverInGrams);
        req.setAttribute("petName", petName);
        req.setAttribute("numberOfCows", numberOfCows);
        req.setAttribute("shareHolding", shareHolding);

        req.getRequestDispatcher("SurveyResult.jsp").forward(req,resp);
    }
}
