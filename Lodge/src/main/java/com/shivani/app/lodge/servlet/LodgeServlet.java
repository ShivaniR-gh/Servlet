package com.shivani.app.lodge.servlet;

import com.shivani.app.lodge.dao.impl.LodgeDAOIMPL;
import com.shivani.app.lodge.dto.LodgeDTO;
import com.shivani.app.lodge.dto.SearchDTO;
import com.shivani.app.lodge.exception.DataDuplicateException;
import com.shivani.app.lodge.exception.DataInvalidException;
import com.shivani.app.lodge.service.LodgeService;
import com.shivani.app.lodge.service.impl.LodgeServiceIMPL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/lodge" , loadOnStartup = 1)
public class LodgeServlet extends HttpServlet {

    private final LodgeService lodgeService = new LodgeServiceIMPL();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("The Servlet post methode is being executed");

        //READ form values from JSP
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String roomType = req.getParameter("roomType");
        String totalAmount = req.getParameter("totalAmount");
        String paymentStatus = req.getParameter("paymentStatus");


        //Store values in request (so JSP can display them back)
        req.setAttribute("name", name);
        req.setAttribute("phoneNumber", phoneNumber);
        req.setAttribute("roomType", roomType);
        req.setAttribute("totalAmount", totalAmount);
        req.setAttribute("paymentStatus", paymentStatus);

        LodgeDTO lodgeDTO = new LodgeDTO(name, Long.parseLong(phoneNumber), roomType, Double.parseDouble(totalAmount), paymentStatus);

        //Send DTO to JSP
        req.setAttribute("dto", lodgeDTO);

        //Try to validate + save  and handles invalid data
        try {
            lodgeService.validateAndSave(lodgeDTO);
            req.setAttribute("successMessage", "The data is valid");
        } catch (DataInvalidException e) {
            req.setAttribute("errorMessage", "The data is invalid");
            req.getRequestDispatcher("lodgeResponse.jsp").forward(req, resp);
            return;
        } catch (DataDuplicateException e) {
            req.setAttribute("errorMessage", "The phone number is duplicate");
            req.getRequestDispatcher("lodgeResponse.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("lodgeResponse.jsp").forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String submit = req.getParameter("submit");
        String phone = req.getParameter("phone");

        // CLEAR BUTTON
        if ("clear".equalsIgnoreCase(submit)) {
            req.setAttribute("dto", null);
            req.setAttribute("message", "");
            req.getRequestDispatcher("lodgeSearch.jsp").forward(req, resp);
            return;
        }

        // VALIDATE PHONE ENTRY
        if (phone == null || phone.trim().isEmpty()) {
            req.setAttribute("message", "Please enter a phone number");
            req.getRequestDispatcher("lodgeSearch.jsp").forward(req, resp);
            return;
        }

        long phoneNumber;

        try {
            phoneNumber = Long.parseLong(phone);
        } catch (NumberFormatException e) {
            req.setAttribute("message", "Phone number must be numeric");
            req.getRequestDispatcher("lodgeSearch.jsp").forward(req, resp);
            return;
        }

        // CALL SERVICE
        SearchDTO searchDTO = new SearchDTO(phoneNumber);
        Optional<LodgeDTO> lodgeDTO = lodgeService.findByPhone(searchDTO);

        if (lodgeDTO.isPresent()) {
            req.setAttribute("dto", lodgeDTO.get());
        } else {
            req.setAttribute("message", "No booking found for this phone number");
        }

        req.getRequestDispatcher("lodgeSearch.jsp").forward(req, resp);
    }
}
