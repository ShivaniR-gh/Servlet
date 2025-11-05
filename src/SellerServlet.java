import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/seller", loadOnStartup = 1)
public class SellerServlet extends GenericServlet {
    public SellerServlet() {
        System.out.println("SellerServlet Object created");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String pincode = request.getParameter("pincode");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String propertyType = request.getParameter("propertyType");
        String price = request.getParameter("price");
        String availableFrom = request.getParameter("availableFrom");

        System.out.println("Seller Details:");
        System.out.println("Name: " + name);
        System.out.println("DOB: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Pincode: " + pincode);
        System.out.println("Email: " + email);
        System.out.println("Mobile: " + mobile);
        System.out.println("Property Type: " + propertyType);
        System.out.println("Price: " + price);
        System.out.println("Available From: " + availableFrom);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
