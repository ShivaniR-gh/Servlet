import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/movie")
public class MovieBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String movieName = req.getParameter("movieName");
        String theatreName = req.getParameter("theatreName");
        String city = req.getParameter("city");
        String seatType = req.getParameter("seatType");
        String request = req.getParameter("request");

        out.println("<h3>🎬 Movie Ticket Booked Successfully!</h3>");
        out.println("<p>Movie: " + movieName + "</p>");
        out.println("<p>Theatre: " + theatreName + "</p>");
        out.println("<p>City: " + city + "</p>");
        out.println("<p>Seat Type: " + seatType + "</p>");
        out.println("<p>Request: " + request + "</p>");
        out.println("<a href=MovieBookingServlet >book again</a>");
    }
}
