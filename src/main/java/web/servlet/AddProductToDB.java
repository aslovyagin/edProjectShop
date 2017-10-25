package web.servlet;

import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProductToDB")
public class AddProductToDB extends HttpServlet {

    public AddProductToDB() {
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        double price = Double.valueOf(req.getParameter("price"));
        String description = req.getParameter("description");

        ProductService.add(title, price, description);
        resp.sendRedirect("/products");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/jsp/pages/addProductToDB.jsp")
                .forward(request, response);
    }
}
