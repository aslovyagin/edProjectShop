package web.servlet;

import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editProductInDB")
public class EditProductInDB extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.valueOf(req.getParameter("id"));
        String title = req.getParameter("title");
        double price = Double.valueOf(req.getParameter("price"));
        String description = req.getParameter("description");

        ProductService.update(id, title, price, description);
        resp.sendRedirect("/products");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.valueOf(request.getParameter("productId"));
        request.setAttribute("product", ProductService.get(productId));

        request.getRequestDispatcher("/jsp/pages/editProductInDB.jsp")
                .forward(request, response);
    }
}
