import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/buyer", loadOnStartup = 1)
public class BuyerServlet extends GenericServlet {
    public BuyerServlet() {
        System.out.println("BuyerServlet Object created");
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
        String budget = request.getParameter("budget");
        String propertyType = request.getParameter("propertyType");

        System.out.println("Buyer Details:");
        System.out.println("Name: " + name);
        System.out.println("DOB: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Pincode: " + pincode);
        System.out.println("Email: " + email);
        System.out.println("Mobile: " + mobile);
        System.out.println("Budget: " + budget);
        System.out.println("Preferred Property Type: " + propertyType);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
