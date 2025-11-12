import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/CookieServlet" , loadOnStartup = 1)
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Cookie cookie = new Cookie("Shivani", String.valueOf(Math.random()));
        cookie.setDomain("x-workz");
        cookie.setDomain("instagram.com");
        cookie.setPath("/");
        resp.addCookie(cookie);
        //resp.sendRedirect("https://x-workz.in");

        out.println("<p>Cookie added successfully!</p>");

    }
}