package web.servlet;

import model.Cart;
import service.CartService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart")
public class ViewCart extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        try {
            processRequest(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            processRequest(req, res);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = (String) request.getSession().getAttribute("login");
        Cart cart = CartService.getCart(login);

        request.setAttribute("clientProducts", cart.getClientProducts());
        request.setAttribute("totalPrice", CartService.getTotalPrice(cart));
        request.setAttribute("totalCount", CartService.getTotalCount(cart));

        request.getRequestDispatcher("/jsp/pages/cart.jsp")
                .forward(request, response);
    }
}
