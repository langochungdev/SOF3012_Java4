package Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import DAO.BaseDAO;
import DAO.UserDAOImpl;
import Entity.User;

@WebServlet("/user/favorites")
public class b3 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BaseDAO<User, Long> dao = new UserDAOImpl();
        User user = dao.findById(Long.parseLong("1"));
        
        req.setAttribute("user", user);
        req.getRequestDispatcher("/pages/b3.jsp").forward(req, resp);
    }
}

