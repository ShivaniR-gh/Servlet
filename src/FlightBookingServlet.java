import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flight")
public class FlightBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        String travelClass = req.getParameter("travelClass");
        String request = req.getParameter("request");

        out.println("<h3>✈️ Flight Ticket Booked Successfully!</h3>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>From: " + source + "</p>");
        out.println("<p>To: " + destination + "</p>");
        out.println("<p>Class: " + travelClass + "</p>");
        out.println("<p>Request: " + request + "</p>");
    }
}
