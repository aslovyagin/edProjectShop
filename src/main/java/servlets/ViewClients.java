package servlets;

import data.daoImpl.ClientDao;
import model.Client;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
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

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <meta charset=\"unicode\">\n" +
                    "    <title>Clients</title>\n" +
                    "    <link rel=\"stylesheet\" href=\"css/main.css\">\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <header>\n" +
                    "        <div>Clients List</div>\n" +
                    "    </header>\n" +
                    "\n" +
                    "    <div>\n" +
                    "        <table>\n" +
                    "            <thead>\n" +
                    "                <tr>\n" +
                    "                    <th>login</th>\n" +
                    "                    <th>lastName</th>\n" +
                    "                    <th>firstName</th>\n" +
                    "                    <th>status</th>\n" +
                    "                </tr>\n" +
                    "            <tbody>\n");

            Set<Client> clients = new ClientDao().getAll();
            for (Client client : clients) {
                out.println("                 <tr>");
                out.println("                    <td>" + client.getLogin() + "</td>");
                out.println("                    <td>" + client.getLastName() + "</td>");
                out.println("                    <td>" + client.getFirstName() + "</td>");
                out.println("                    <td>" + client.getStatus().toString() + "</td>");
                out.println("                 </tr>");
            }

            out.println("            </tbody>\n" +
                    "        </table>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }
}
