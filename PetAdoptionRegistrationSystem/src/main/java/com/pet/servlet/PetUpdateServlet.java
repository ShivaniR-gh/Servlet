package com.pet.servlet;

import com.pet.dto.PetAdaptionDTO;
import com.pet.dto.SearchDTO;
import com.pet.service.PetService;
import com.pet.service.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/editPet", loadOnStartup = 1)
public class PetUpdateServlet extends HttpServlet {

    private PetService petService = new PetServiceImpl();

    public PetUpdateServlet() {
        System.out.println("Created PetUpdateServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Running doGet in PetUpdateServlet");
        System.out.println("Forwarding to PetUpdate.jsp");

        // Get phone number from request
        String phone = req.getParameter("phone");
        System.out.println("Searching for phone: " + phone);

        SearchDTO searchDTO = new SearchDTO(phone);

        Optional<PetAdaptionDTO> optionalDTO = petService.findByPhone(searchDTO);

        if (optionalDTO.isPresent()) {
            req.setAttribute("editDTO", optionalDTO.get());
        } else {
            req.setAttribute("message", "Record Not Found for phone: " + phone);
        }

        req.getRequestDispatcher("PetUpdate.jsp").forward(req, resp);
    }
}
