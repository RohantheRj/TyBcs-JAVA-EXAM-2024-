import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitCounterServlet")
public class VisitCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        Cookie[] cookies = request.getCookies();
        Cookie visitCookie = null;
        int visitCount = 0;


        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    visitCookie = cookie;
                    break;
                }
            }
        }


        if (visitCookie != null) {
            visitCount = Integer.parseInt(visitCookie.getValue());
        }


        visitCount++;


        visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        response.addCookie(visitCookie);

        out.println("<html><head><title>Visit Counter Servlet</title></head><body>");
        if (visitCount == 1) {
            out.println("<h2>Welcome! This is your first visit.</h2>");
        } else {
            out.println("<h2>You have visited this page " + visitCount + " times.</h2>");
        }
        out.println("</body></html>");
    }
}

