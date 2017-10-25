package web.servlet;

import service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProductToCart")
public class AddProductToCart extends HttpServlet {

    public AddProductToCart() {
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int productId = Integer.valueOf(req.getParameter("productId"));
        String login = (String) req.getSession().getAttribute("login");

        CartService.addProductToCart(login, productId);
        resp.sendRedirect("/products");
    }
}
