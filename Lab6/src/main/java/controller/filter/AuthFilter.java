package controller.filter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entity.User;

@WebFilter({
    "/admin/*",
    "/account/change-password",
    "/account/edit-profile",
    "/video/like/*",
    "/video/share/*"
})
public class AuthFilter implements Filter {
    public static final String SECURITY_URI = "securityUri";

    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String uri = req.getRequestURI();

        if (user == null || (uri.contains("/admin/") && !user.getAdmin())) {
            session.setAttribute(AuthFilter.SECURITY_URI, uri);
            resp.sendRedirect(req.getContextPath() + "/account/sign-in");
        } else {
            chain.doFilter(request, response);
        }
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }
}
