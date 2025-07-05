package Controller;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.VideoDAOImpl;
import Entity.Video;

@WebServlet("/videoSearch")
public class b3 extends HttpServlet {
    private VideoDAOImpl videoDAO = new VideoDAOImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Video> videos = null;

        if (keyword != null && !keyword.trim().isEmpty()) {
            videos = videoDAO.findByKeyword(keyword);
        } else {
            videos = videoDAO.findAll(); 
        }

        req.setAttribute("videos", videos);
        req.setAttribute("keyword", keyword);
        req.getRequestDispatcher("/pages/b3.jsp").forward(req, resp);
    }
}
