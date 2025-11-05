import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.swing.text.GapContent;
import java.io.IOException;
@WebServlet(urlPatterns = "/drive" , loadOnStartup = 1)
public class DL extends GenericServlet {
    public DL() {
        System.out.println("Object created");
    }
    @Override

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        String fullname = servletRequest.getParameter("fullname");
        String dob = servletRequest.getParameter("dob");
        String gender = servletRequest.getParameter("gender");
        String address = servletRequest.getParameter("address");
        String city = servletRequest.getParameter("city");
        String state = servletRequest.getParameter("state");
        String pincode = servletRequest.getParameter("pincode");
        String email = servletRequest.getParameter("email");
        String mobile = servletRequest.getParameter("mobile");
        String aadhar = servletRequest.getParameter("aadhar");
        String vehicleType = servletRequest.getParameter("vehicleType");
        String bloodGroup = servletRequest.getParameter("bloodGroup");
        String issueDate = servletRequest.getParameter("issueDate");
        String expiryDate = servletRequest.getParameter("expiryDate");
        String officeLocation = servletRequest.getParameter("officeLocation");

        System.out.println("Full Name: " + fullname);
        System.out.println("DOB: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Pincode: " + pincode);
        System.out.println("Email: " + email);
        System.out.println("Mobile: " + mobile);
        System.out.println("Aadhar: " + aadhar);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Office Location: " + officeLocation);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
