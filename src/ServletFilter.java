import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebFilter("/*")
public class ServletFilter implements Filter {
    public void init(FilterConfig filterConfig) {
        System.out.println("LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Request received at: "+  new java.util.Date());
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Response sent at: " + new java.util.Date());

    }

    @Override
    public void destroy() {
        System.out.println("Filter servlets executed");
    }
}
