package Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import DAO.BaseDAO;
import DAO.UserDAOImpl;
import Entity.User;

@WebServlet("/video/favorites")
public class b4 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BaseDAO<User, Long> dao = new UserDAOImpl();
        List<User> users = dao.findAll();
        
        req.setAttribute("users", users);
        req.getRequestDispatcher("/pages/b4.jsp").forward(req, resp);
    }
}

