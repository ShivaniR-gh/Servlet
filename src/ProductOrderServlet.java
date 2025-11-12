import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/product")
public class ProductOrderServlet extends HttpServlet {
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

        String product = req.getParameter("product");
        String quantity = req.getParameter("quantity");
        String category = req.getParameter("category");
        String delivery = req.getParameter("delivery");
        String address = req.getParameter("address");

        out.println("<h3>Product Ordered Successfully!</h3>");
        out.println("<p>Product: " + product + "</p>");
        out.println("<p>Quantity: " + quantity + "</p>");
        out.println("<p>Category: " + category + "</p>");
        out.println("<p>Delivery Type: " + delivery + "</p>");
        out.println("<p>Address: " + address + "</p>");
    }
}
