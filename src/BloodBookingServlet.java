import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/blood")
public class BloodBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String group = req.getParameter("group");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");

        out.println("<h3> Blood Donation Booked Successfully!</h3>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Age: " + age + "</p>");
        out.println("<p>Blood Group: " + group + "</p>");
        out.println("<p>Gender: " + gender + "</p>");
        out.println("<p>Address: " + address + "</p>");
    }
}
