package servlets;

import data.daoImpl.ClientDao;
import model.Client;
import service.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ViewClients extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        List<Client> clients = ClientService.getAllClients();
        System.out.println(clients.size());
        request.setAttribute("clients", clients);
//        httpSession.setAttribute("clients", clients1);

//        RequestDispatcher requestDispatcher = getServletContext()
//                .getRequestDispatcher("/jsp/pages/clients.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }

//        request.getRequestDispatcher("/jsp/pages/clients.jsp")
//                .forward(request, response);

        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/jsp/pages/clients.jsp");

        rd.forward(request, response);

    }
}
