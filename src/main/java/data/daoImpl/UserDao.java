package data.daoImpl;

import data.DaoInterface;
import data.pool.ConnectionPool;
import model.User;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDao implements DaoInterface<User, String> {
    private ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public User get(String login) {
        Connection connection = pool.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE login=" + login);

            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<User> getAll() {
        Connection connection = pool.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            Set products = new HashSet();
            while (rs.next()) {
                User user = extractUserFromResultSet(rs);
                products.add(user);
            }
            return products;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(User user) {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (?, ?)");
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET password=? WHERE login=?");
            ps.setString(1, user.getPassword());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String login) {
        Connection connection = pool.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + login);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteAll() {
        Connection connection = pool.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE  FROM user");
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        return user;
    }

    public boolean checkPassword(String login, String password) {
        Connection connection = pool.getConnection();
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
