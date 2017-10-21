package servlets;

import data.daoImpl.ProductDao;
import model.Product;
import service.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class ViewProducts extends HttpServlet {

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


        HttpSession session = request.getSession(true);
        PrintWriter out = response.getWriter();
        Set<Product> products = ProductService.getAllProducts();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hola</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        out.println("<hr>");
        out.println("<hr>");
        out.println("<hr>");
        for (Product product : products) {
            out.println(product.getName());
            out.println(product.getPrice());
            out.println(product.getDescription());
            out.println("<hr>");
        }
        out.println("</body>");
        out.println("</html>");

        out.close();

    }
}
