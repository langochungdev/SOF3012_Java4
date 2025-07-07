package servlet;

import dao.VideoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Video;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/admin/videos")
@MultipartConfig
public class AdminVideoServlet extends HttpServlet {
    private VideoDAO videoDAO = new VideoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Video video = videoDAO.findById(id);
            req.setAttribute("form", video);
        }

        List<Video> list = videoDAO.findAll();
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
        String viewsStr = req.getParameter("views");
        int views = (viewsStr != null && !viewsStr.isEmpty()) ? Integer.parseInt(viewsStr) : 0;

        boolean active = "true".equals(req.getParameter("active"));

        String posterName = null;
        Part filePart = req.getPart("posterFile");
        if (filePart != null && filePart.getSize() > 0) {
            String realPath = req.getServletContext().getRealPath("/assets/img");
            File dir = new File(realPath);
            if (!dir.exists()) dir.mkdirs();

            String filename = UUID.randomUUID().toString() + "_" + filePart.getSubmittedFileName();
            filePart.write(realPath + "/" + filename);
            posterName = filename;
        }

        try {
            if ("create".equals(action)) {
                Video v = new Video(id, title, posterName != null ? posterName : "poster.jpg", views, description, active);
                videoDAO.create(v);
            } else if ("update".equals(action)) {
                Video v = videoDAO.findById(id);
                if (v != null) {
                    v.setTitle(title);
                    v.setDescription(description);
                    v.setViews(views);
                    v.setActive(active);
                    if (posterName != null) {
                        v.setPoster(posterName);
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
