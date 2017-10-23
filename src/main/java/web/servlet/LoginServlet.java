package web.servlet;

import data.daoImpl.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new UserDao().get(username);

        if (user != null && new UserDao().checkPassword(username, password)) {
            httpSession.setAttribute("PRINCIPAL", user);
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("WEB-INF/jsp/pages/index.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return;
        }
        response.sendRedirect("WEB-INF/jsp/pages/login.jsp");
    }
}
