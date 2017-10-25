package web.servlet;

import service.ClientService;
import service.RegService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {

    public RegServlet() {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String password = request.getParameter("password");

        if (RegService.addClient(login, lastName, firstName, password)) {
            HttpSession session = request.getSession();

            session.setAttribute("login", login);
            session.setAttribute("status", ClientService.getStatus(login));

            response.sendRedirect("/products");
        } else {
            request.setAttribute("cause", "That login is taken. Try another.");
            request.getRequestDispatcher("/jsp/pages/reg.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/jsp/pages/reg.jsp")
                .forward(request, response);
    }
}

