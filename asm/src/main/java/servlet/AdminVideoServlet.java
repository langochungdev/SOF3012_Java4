package servlet;

import dao.VideoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Video;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/videos")
public class AdminVideoServlet extends HttpServlet {
    private VideoDAO videoDAO = new VideoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Video video = videoDAO.findById(id);
            req.setAttribute("form", video);
        }

        List<Video> list = videoDAO.findAllEdit();
        req.setAttribute("videos", list);
        req.setAttribute("view", "admin/videos");
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String poster = req.getParameter("poster"); // lấy từ input text poster
        String viewsStr = req.getParameter("views");
        int views = (viewsStr != null && !viewsStr.isEmpty()) ? Integer.parseInt(viewsStr) : 0;
        boolean active = "true".equals(req.getParameter("active"));

        try {
            if ("create".equals(action)) {
                Video v = new Video(id, title, poster != null && !poster.isEmpty() ? poster : "poster.jpg", views, description, active);
                videoDAO.create(v);
            } else if ("update".equals(action)) {
                Video v = videoDAO.findById(id);
                if (v != null) {
                    v.setTitle(title);
                    v.setDescription(description);
                    v.setViews(views);
                    v.setActive(active);
                    if (poster != null && !poster.isEmpty()) {
                        v.setPoster(poster);
                    }
                    videoDAO.update(v);
                }
            } else if ("delete".equals(action)) {
                videoDAO.deleteById(id);
            } else if ("reset".equals(action)) {
                resp.sendRedirect("videos");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("videos");
    }
}
