package Controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.VideoDAOImpl;

@WebServlet("/videoSummary")
public class b4 extends HttpServlet {
    private VideoDAOImpl videoDAO = new VideoDAOImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object[]> summary = videoDAO.getVideoShareSummary();
        req.setAttribute("summary", summary);
        req.getRequestDispatcher("/pages/b4.jsp").forward(req, resp);
    }
}
