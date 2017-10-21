package filter;

import model.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthFilter implements Filter {

    private List<String> pathFilters = Arrays.asList(new String[]{"ViewProducts", ""});

    public AuthFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        String uri = ((HttpServletRequest) request).getRequestURI();
        String path = StringUtils.substringAfterLast(uri, "/");
        if (!pathFilters.contains(path)) {
            filterChain.doFilter(request, response);
            return;
        }
        HttpSession session = ((HttpServletRequest) request).getSession();
        User user = (User) session.getAttribute("PRINCIPAL");
        if (user != null) {
            filterChain.doFilter(request, response);
            return;
        }

        ((HttpServletResponse) response).sendRedirect("jsp/pages/login.jsp");
    }

    @Override
    public void destroy() {

    }
}
