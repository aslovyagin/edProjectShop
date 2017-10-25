package web.servlet;

import model.Client;
import service.AuthService;
import service.ClientService;

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

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (new AuthService().checkPassword(login, password)) {
            HttpSession session = request.getSession();

            session.setAttribute("login", login);
            Client.Status status = ClientService.getStatus(login);
            session.setAttribute("status", status);

            if (status == Client.Status.BLOCKED)
                request.getRequestDispatcher("/jsp/pages/blocked.jsp").forward(request, response);
            else
                response.sendRedirect("/products");
        } else {
            request.setAttribute("cause", "Login or password is invalid.");
            request.getRequestDispatcher("/jsp/pages/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/jsp/pages/login.jsp")
                .forward(request, response);
    }
}
