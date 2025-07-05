package Controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import DAO.UserDAOImpl;
import Entity.User;

@WebServlet("/login")
public class b2 extends HttpServlet {
    private UserDAOImpl userDAO = new UserDAOImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/b2.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idOrEmail = req.getParameter("idOrEmail");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        User user = userDAO.findByIdOrEmail(idOrEmail);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            req.setAttribute("error", "thanh cong");
        } else {
            req.setAttribute("error", "Sai username/email hoặc mật khẩu");
        }
        req.getRequestDispatcher("/pages/b2.jsp").forward(req, resp);
    }
}
