package servlets;

import data.daoImpl.UserDao;
import data.pool.ConnectionPool;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class LoginServlet extends HttpServlet {


    public LoginServlet() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        try (Connection con = ConnectionPool.getInstance().getConnection();
//             Statement stmt = con.createStatement()) {
//
//            ResultSet rs = stmt.executeQuery("SELECT password FROM user WHERE id = 0");
//
//            if (rs.next()) {
//                System.out.println(rs.getString("password"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        HttpSession httpSession = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new UserDao().get(username);

        if (user != null && new UserDao().checkPassword(username, password)) {
            httpSession.setAttribute("PRINCIPAL", user);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/jsp/pages/index.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return;

        }
        response.sendRedirect("jsp/pages/login.jsp");
    }
}
