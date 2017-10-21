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


        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("surName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String adress = request.getParameter("adress");


        boolean i = RegService.addCleint(firstName,surName,adress, login,password);
        request.getRequestDispatcher("jsp/pages/loginTEST.jsp").forward(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
