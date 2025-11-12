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

        Cookie[] cookies = req.getCookies();
        if( cookies == null || cookies.length == 0 ){
            out.println("<p>A new cookie has been added.</p>");
        }else {
            out.println("<h3>Cookies Found:</h3>");
            for (Cookie cookie1 : cookies) {
                System.out.println("Name : " + cookie1.getName() + " Value : " + cookie1.getValue());
            }
        }
        String movieName = req.getParameter("movieName");
        String theatreName = req.getParameter("theatreName");
        String city = req.getParameter("city");
        String seatType = req.getParameter("seatType");
        String request = req.getParameter("request");

        out.println("<head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB\" crossorigin=\"anonymous\"></head>");
        out.println("<div container mt-5>");
        out.println("<div class='card-body'>");
        out.println("<h3 class='text-primary'> Movie Ticket Booked Successfully!</h3>");
        out.println("<ul class='list-group mb-3'>");
        out.println("<li class='list-group-item'><strong>Movie:</strong> " + movieName + "</li>");
        out.println("<li class='list-group-item'><strong>Theatre:</strong> " + theatreName + "</li>");
        out.println("<li class='list-group-item'><strong>City:</strong> " + city + "</li>");
        out.println("<li class='list-group-item'><strong>Seat Type:</strong> " + seatType + "</li>");
        out.println("<li class='list-group-item'><strong>Request:</strong> " + request + "</li>");
        out.println("<a href='Movie.html'>"+"ReBook"+"</a>");
        out.println("</ul>");
        out.println("</div>");
        out.println("</ div");
    }
}
