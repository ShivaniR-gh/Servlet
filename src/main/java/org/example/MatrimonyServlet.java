package org.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/matrimony")
public class MatrimonyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("email", req.getParameter("email"));
        req.setAttribute("gender", req.getParameter("gender"));
        req.setAttribute("forValue", req.getParameter("forValue"));
        req.setAttribute("dob", req.getParameter("dob"));
        req.setAttribute("motherTongue", req.getParameter("motherTongue"));
        req.setAttribute("religion", req.getParameter("religion"));
        req.setAttribute("maritalStatus", req.getParameter("maritalStatus"));
        req.setAttribute("height", req.getParameter("height"));

        req.getRequestDispatcher("response.jsp").forward(req, resp);
    }
}
