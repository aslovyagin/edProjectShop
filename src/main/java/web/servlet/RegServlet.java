package servlets;

import service.RegService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    public RegServlet() {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String surName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String password = request.getParameter("password");

        boolean i = RegService.addClient(firstName,surName, login,password);
        request.getRequestDispatcher("jsp/pages/login.jsp").forward(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
