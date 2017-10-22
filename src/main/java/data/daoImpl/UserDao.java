package data.daoImpl;

import data.DaoInterface;
import data.pool.ConnectionPool;
import model.User;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDao implements DaoInterface<User, String> {
    private ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public User get(String login) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT login, password FROM user WHERE login = ?")) {

            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            return rs.next()
                    ? extractUserFromResultSet(rs)
                    : null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<User> getAll() {
        try (Connection con = pool.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT login, password FROM user")) {

            Set<User> users = new HashSet<>();
            while (rs.next())
                users.add(extractUserFromResultSet(rs));

            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(User user) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO user VALUES (?, ?)")) {

            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(User user) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE user SET password = ? WHERE login = ?")) {

            ps.setString(1, user.getPassword());
            ps.setString(2, user.getLogin());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String login) {
        if (true)
            throw new NotImplementedException("should delete linked client " +
                    "and then user will be deleted automatically " +
                    "due to ON DELETE CASCADE clause");

        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "DELETE FROM user WHERE login = ?")) {

            ps.setString(1, login);
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkPassword(String login, String password) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT password FROM user WHERE login = ?")) {

            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            return rs.next() && password.equals(rs.getString("password"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        return new User(
                rs.getString("login"),
                rs.getString("password")
        );
    }
}
