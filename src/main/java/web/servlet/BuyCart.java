package web.servlet;

import service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buy")
public class BuyCart extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = (String) request.getSession().getAttribute("login");

        CartService.createCartByLogin(login);
        response.sendRedirect("/products");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = (String) request.getSession().getAttribute("login");

        CartService.createCartByLogin(login);
        response.sendRedirect("/products");
    }
}
