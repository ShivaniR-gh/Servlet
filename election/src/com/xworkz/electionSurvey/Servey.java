package com.xworkz.electionSurvey;

import com.xworkz.electionSurvey.dto.ServeyDTO;
import com.xworkz.electionSurvey.exception.DataInvalidException;
import com.xworkz.electionSurvey.dto.impl.Surveyimpl;
import com.xworkz.electionSurvey.service.ServeyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/survey",loadOnStartup = 1)

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



        ServeyDTO serveyDTO = new ServeyDTO(
                name, occupation, education, nativePlace, bikeNumber, carNumber,
                Long.parseLong(mobileNumber), Long.parseLong(aadharNumber), panCardNumber,
                Long.parseLong(voterIDNumber)
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

        req.getRequestDispatcher("SurveyResult.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Survey.jsp").forward(req, resp);
    }
}
