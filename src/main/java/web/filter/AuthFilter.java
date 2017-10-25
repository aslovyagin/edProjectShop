package web.filter;

import model.Client;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    public AuthFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("AuthFilter doFilter");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        HttpServletResponse res = (HttpServletResponse) response;

        String loginURI = req.getContextPath() + "/login";
        String regURI = req.getContextPath() + "/reg";

        boolean loggedIn = session != null
                && session.getAttribute("login") != null
                && session.getAttribute("status") != Client.Status.BLOCKED;

        String url = req.getRequestURI();
        boolean loginRequest = url.equals(loginURI);
        boolean regRequest = url.equals(regURI);
        boolean libUsed = url.length() >= 5 && url.substring(0, 5).equals("/lib/");

        if (loggedIn || loginRequest || regRequest || libUsed) {
            filterChain.doFilter(request, response);
        } else {
            res.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
    }
}

