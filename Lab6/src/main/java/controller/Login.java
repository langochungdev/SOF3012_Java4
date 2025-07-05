package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import controller.filter.AuthFilter;
import dao.UserDAOImpl;
import entity.User;

@WebServlet("/account/sign-in")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDAOImpl dao = new UserDAOImpl();
        User user = dao.findById(Long.parseLong(username));


        if (user == null) {
            req.setAttribute("message", "Invalid username");
        } else if (!user.getPassword().equals(password)) {
            req.setAttribute("message", "Invalid password");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            req.setAttribute("message", "Login successfully");

            String securityUri = (String) session.getAttribute(AuthFilter.SECURITY_URI);
            if (securityUri != null) {
                resp.sendRedirect(securityUri);
                return;
            }
        }

        req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }
}
