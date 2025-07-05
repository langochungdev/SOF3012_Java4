package Controller;
import DAO.UserDAOImpl;
import Entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class b1 extends HttpServlet {
    UserDAOImpl userDAO = new UserDAOImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userDAO.findById(Long.parseLong(id));
        if (user == null) {
            req.setAttribute("error", "Sai username");
            req.getRequestDispatcher("/pages/b1.jsp").forward(req, resp);
        } else if (!user.getPassword().equals(password)) {
            req.setAttribute("error", "Sai password");
            req.getRequestDispatcher("/pages/b1.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/pages/home.jsp");
        }
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("logout".equals(action)) req.getSession().invalidate();
        if (req.getSession(false) == null) System.out.println("đã huỷ");
        req.getRequestDispatcher("/pages/b1.jsp").forward(req, resp);
        
    }
}
