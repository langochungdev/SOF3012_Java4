package Controller;
import DAO.LogDAOImpl;
import Entity.Log;
import Entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter("/*")
public class b3_AppFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpServletRequest req = (HttpServletRequest) request;
        
        chain.doFilter(request, response);
        
        HttpSession session = req.getSession(false);
        if (session == null) return;

        Object userObj = session.getAttribute("user");
        if (userObj == null) return;

        String username = null;
        try {
            User user = (User) userObj;
            username = user.getFullname();
        } catch (Exception e) {
            return;
        }

        Log l = new Log();
        l.setUrl(req.getRequestURI());
        l.setAccessTime(LocalDateTime.now());
        l.setUsername(username);

        try {
            LogDAOImpl dao = new LogDAOImpl();
            dao.create(l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
