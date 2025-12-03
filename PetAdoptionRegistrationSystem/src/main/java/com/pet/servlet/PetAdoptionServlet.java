package com.pet.servlet;

import com.pet.dao.PetDAO;
import com.pet.dao.PetDAOImpl;
import com.pet.dto.PetAdaptionDTO;
import com.pet.exception.DataInvalidException;
import com.pet.service.PetService;
import com.pet.service.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/adopt" , loadOnStartup = 1)
public class PetAdoptionServlet extends HttpServlet {
    private final PetDAO petDAO = new PetDAOImpl();
    private final PetService petService = new PetServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String phone = req.getParameter("phone");
        String  experience = req.getParameter("experience");
        String petType = req.getParameter("petType");

        PetAdaptionDTO petAdaptionDTO = new PetAdaptionDTO(name , city , phone , Integer.parseInt(experience) , petType);


        try {
            petService.validate(petAdaptionDTO);
            boolean saved = petDAO.save(petAdaptionDTO);
            if(saved) {
                req.setAttribute("successMessage", "The data has been validated and saved successfully");
            }
            else {
                req.setAttribute("rerorMessage" , "The data is not saved");

            }
        } catch (DataInvalidException | SQLException e) {
            req.setAttribute("errorMessage" , "The data is not valid , please enter the valid data");
        }


        req.setAttribute("name" , name);
        req.setAttribute("city" , city);
        req.setAttribute("phone" , phone);
        req.setAttribute("experience" , experience);
        req.setAttribute("petType" , petType);
        req.getRequestDispatcher("AdoptionResponse.jsp").forward(req , resp);
    }
}
