package servlets;

import data.daoImpl.UserDao;
import model.User;
import service.AuthService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    public LoginServlet() {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new UserDao().get("\"" + username + "\"");

        if (user != null && new AuthService().checkPassword("\"" + username + "\"", "\"" + password + "\"")) {
            httpSession.setAttribute("user", user);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/jsp/pages/index.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return;

        }
        request.getRequestDispatcher("/jsp/pages/login.jsp").forward(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/pages/login.jsp").forward(request, response);
    }
}