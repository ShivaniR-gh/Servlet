import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet(urlPatterns = "/pat"  , loadOnStartup = 1)
public class PatientServlet extends GenericServlet {
    public PatientServlet(){
        System.out.println("Object created");
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet Initialized");
        String name = servletRequest.getParameter("name");
        String age = servletRequest.getParameter("age");
        String gender = servletRequest.getParameter("gender");
        String phone = servletRequest.getParameter("phone");
        String address = servletRequest.getParameter("address");
        String email = servletRequest.getParameter("email");
        String diseases = servletRequest.getParameter("diseases");
        String doctor = servletRequest.getParameter("doctor");
        String admitteddate = servletRequest.getParameter("doa");
        String roomnumber= servletRequest.getParameter("roomnumber");
        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(phone);
        System.out.println(address);
        System.out.println(email);
        System.out.println(diseases);
        System.out.println(doctor);
        System.out.println(admitteddate);
        System.out.println(roomnumber);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}


