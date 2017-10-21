package servlets;

import data.daoImpl.UserDao;
import model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class ViewUsers extends HttpServlet {

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

        HttpSession session = request.getSession(true);
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
                    "                    <th>id</th>\n" +
                    "                    <th>last name</th>\n" +
                    "                    <th>first name</th>\n" +
                    "                    <th>login</th>\n" +
                    "                    <th>status</th>\n" +
                    "                </tr>\n" +
                    "            <tbody>\n");

            Set<User> users = new UserDao().getAll();
            for (User user : users) {
                System.out.println(user.getLastName());

                out.println("                 <tr>");
                out.println("                    <td>" + user.getId() + "</td>");
                out.println("                    <td>" + user.getLastName() + "</td>");
                out.println("                    <td>" + user.getFirstName() + "</td>");
                out.println("                    <td>" + user.getLogin() + "</td>");
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
