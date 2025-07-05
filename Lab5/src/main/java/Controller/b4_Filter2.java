package Controller;
import jakarta.servlet.*;
import java.io.IOException;

public class b4_Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.print(request.getAttribute("hello"));
        chain.doFilter(request, response);
    }
}

