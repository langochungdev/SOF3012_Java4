package Controller;
import jakarta.servlet.*;
import java.io.IOException;

public class b4_Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setAttribute("hello", "Tôi là filter 1");
        chain.doFilter(request, response);
    }
}

