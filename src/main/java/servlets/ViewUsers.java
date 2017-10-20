package servlets;

import data.daoImpl.UserDao;
import model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        try (PrintWriter out = response.getWriter()) {

            out.println("<head>\n" +
                    "    <meta charset=\"utf-8\">\n" +
                    "    <title>goods</title>\n" +
                    "    <link rel=\"stylesheet\" href=\"main.css\">\n" +
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

            int i = 0;
            Set<User> users = new UserDao().getAll();
            for (User user : users) {
                out.println("                 <tr>");
                out.println("                    <td>" + ++i + "</td>");
                out.println("                    <td>lastName</td>");
                out.println("                    <td>firstName</td>");
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
