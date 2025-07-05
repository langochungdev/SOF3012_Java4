package servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/download")
public class download extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain");
        String data = "{\"name\":\"Tuấn\", \"age\":20, \"gender\":true}";
        resp.getWriter().print(data);
    }
}
