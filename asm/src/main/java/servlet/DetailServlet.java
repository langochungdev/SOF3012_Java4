package servlet;

import dao.VideoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Video;

import java.io.IOException;
import java.util.List;

@WebServlet({"/detail", "/admin/detail"})
public class DetailServlet extends HttpServlet {
	private VideoDAO videoDAO = new VideoDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        String id = req.getParameter("id");
	        if (id == null || id.isBlank()) {
	            resp.sendRedirect("home");
	            return;
	        }

	        Video current = videoDAO.findById(id);
	        if (current == null) {
	            resp.sendRedirect("home");
	            return;
	        }

	        // tăng lượt xem
	        current.setViews(current.getViews() + 1);
	        videoDAO.update(current);

	        List<Video> all = videoDAO.findAll();

	        req.setAttribute("video", current);
	        req.setAttribute("suggestions", all);

	        String uri = req.getRequestURI();
	        if (uri.contains("/admin/")) {
	            req.setAttribute("view", "user/detail"); // dùng lại detail.jsp nhưng load vào admin.jsp
	            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
	        } else {
	            req.setAttribute("includePage", "/user/detail.jsp");
	            req.getRequestDispatcher("/index.jsp").forward(req, resp);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        resp.sendError(500, "Lỗi khi hiển thị video");
	    }
	}

}
