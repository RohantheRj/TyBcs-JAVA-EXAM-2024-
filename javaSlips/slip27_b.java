import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionTimeoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession();


        int currentTimeout = session.getMaxInactiveInterval();


        int newTimeout = 300; 
        session.setMaxInactiveInterval(newTimeout);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Session Timeout Changed</title></head><body>");
        out.println("<h1>Session Timeout Changed</h1>");
        out.println("<p>Previous Timeout: " + currentTimeout + " seconds</p>");
        out.println("<p>New Timeout: " + newTimeout + " seconds</p>");
        out.println("<p>Session Timeout has been changed successfully.</p>");
        out.println("</body></html>");
    }
}

