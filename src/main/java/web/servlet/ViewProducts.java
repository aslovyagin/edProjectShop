package web.servlet;

import service.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ViewProducts")
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

        request.setAttribute("allProducts", ProductService.getAllProducts());

        request.getRequestDispatcher("jsp/pages/products.jsp")
                .forward(request, response);


//
//        PrintWriter out = response.getWriter();
//        Set<Product> products = new ProductDao().getAll();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Hola</title>");
//        out.println("</head>");
//        out.println("<body bgcolor=\"white\">");
//        out.println("<hr>");
//        out.println("<hr>");
//        out.println("<hr>");
//        for (Product product : products) {
//            out.println(product.getTitle());
//            out.println(product.getPrice());
//            out.println(product.getDescription());
//            out.println("<hr>");
//        }
//        out.println("</body>");
//        out.println("</html>");
//
//        out.close();
    }
}