package com.pet.servlet;

import com.pet.dto.PetAdaptionDTO;
import com.pet.dto.SearchDTO;
import com.pet.exception.DataDuplicateException;
import com.pet.exception.DataInvalidException;
import com.pet.service.PetService;
import com.pet.service.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/adopt", loadOnStartup = 1)
public class PetAdoptionServlet extends HttpServlet {

    private final PetService petService = new PetServiceImpl();

    public PetAdoptionServlet() {
        System.out.println("PetAdoptionServlet created");
    }

    // ---------------------------- POST (SAVE) ----------------------------
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Processing Pet Adoption Form...");

        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String petType = req.getParameter("petType");
        String expStr = req.getParameter("experience");
        String phone = req.getParameter("phone");

        // Send back to UI
        req.setAttribute("name", name);
        req.setAttribute("city", city);
        req.setAttribute("petType", petType);
        req.setAttribute("experience", expStr);
        req.setAttribute("phone", phone);

        // Cookie Logging (Same as AquaServlet)
        Cookie[] cookies = req.getCookies();
        if (cookies == null || cookies.length == 0) {
            System.out.println("No cookies found.");
        } else {
            for (Cookie c : cookies) {
                System.out.println("Cookie: " + c.getName() + " = " + c.getValue());
            }
        }

        int experience = 0;
        try {
            experience = Integer.parseInt(expStr);
        } catch (NumberFormatException e) {
            req.setAttribute("failureMessage", "Experience must be a number!");
            req.getRequestDispatcher("AdoptionResponse.jsp").forward(req, resp);
            return;
        }

        // DTO creation (same setter style as fish)
        PetAdaptionDTO dto = new PetAdaptionDTO();
        dto.setName(name);
        dto.setCity(city);
        dto.setPetType(petType);
        dto.setExperience(experience);
        dto.setPhone(phone);

        System.out.println("DTO received: " + dto);

        try {
            boolean saved = petService.validateAndSave(dto);

            if (saved) {
                req.setAttribute("successMessage", "Your data saved successfully!");
            } else {
                req.setAttribute("failureMessage", "Duplicate Entry: phone already exists.");
            }

        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
            req.setAttribute("failureMessage", e.getMessage());
            req.getRequestDispatcher("AdoptionResponse.jsp").forward(req, resp);
            return;
        }

        req.getRequestDispatcher("AdoptionResponse.jsp").forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String submit = req.getParameter("submit");

        // Same "clear" behavior as AquaServlet
        if ("clear".equalsIgnoreCase(submit)) {
            req.setAttribute("dto", null);
        } else {
            String phone = req.getParameter("phone");
            System.out.println("Search requested for phone: " + phone);

            SearchDTO searchDTO = new SearchDTO(phone);

            Optional<PetAdaptionDTO> optional = petService.findByPhone(searchDTO);

            if (optional.isPresent()) {
                req.setAttribute("dto", optional.get());
            } else {
                req.setAttribute("message", "No adoption record found for phone: " + phone);
            }
        }

        req.getRequestDispatcher("PetSearch.jsp").forward(req, resp);
    }
}
