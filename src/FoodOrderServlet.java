import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/food")
public class FoodOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if( cookies == null || cookies.length == 0 ){
            out.println("<p>No cookies found. A new cookie has been added.</p>");
        }else {
            out.println("<h3>Cookies Found:</h3>");
            for (Cookie cookie1 : cookies) {
                System.out.println("Name : " + cookie1.getName() + " Value : " + cookie1.getValue());
            }
        }

        String name = req.getParameter("name");
        String dish = req.getParameter("dish");
        String type = req.getParameter("type");
        String spice = req.getParameter("spice");
        String address = req.getParameter("address");

        out.println("<h3>🍴 Food Ordered Successfully!</h3>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Dish: " + dish + "</p>");
        out.println("<p>Type: " + type + "</p>");
        out.println("<p>Spice Level: " + spice + "</p>");
        out.println("<p>Address: " + address + "</p>");
    }
}
