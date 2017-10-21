package service;

import data.ConnectionFactory;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthService {
    public boolean checkPassword(String login, String password) {
        Connection connection = ConnectionFactory.getConnection();
        User user = new User();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE login=" + login);
            if (rs.next()) {
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (password.equals("\"" + user.getPassword() + "\"")) {
            return true;
        } else {
            return false;
        }
    }
}
