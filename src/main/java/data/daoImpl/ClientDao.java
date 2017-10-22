package data.daoImpl;

import data.DaoInterface;
import data.pool.ConnectionPool;
import model.Client;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ClientDao implements DaoInterface<Client, String> {
    private ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public Client get(String login) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT login, lastName, firstName, status " +
                             "FROM client WHERE login = ?")) {

            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            return rs.next()
                    ? extractClientFromResultSet(rs)
                    : null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SortedSet<Client> getAll() {
        try (Connection con = pool.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT login, lastName, firstName, status FROM client")) {

            SortedSet<Client> clients = new TreeSet<>();
            while (rs.next())
                clients.add(extractClientFromResultSet(rs));

            return clients;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(Client Client) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO client (login, lastName, firstName, status) " +
                             "VALUES (?, ?, ?, ?)")) {

            ps.setString(1, Client.getLogin());
            ps.setString(2, Client.getLastName());
            ps.setString(3, Client.getFirstName());
            ps.setString(4, Client.getStatus().toString());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Client Client) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE client SET (lastName, firstName, status) = " +
                             "(?, ?, ?) WHERE login = ?")) {

            ps.setString(1, Client.getLastName());
            ps.setString(2, Client.getFirstName());
            ps.setString(3, Client.getStatus().toString());
            ps.setString(4, Client.getLogin());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String login) {
        // linked user will be deleted automatically
        // due to ON DELETE CASCADE clause
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "DELETE FROM client WHERE login = ?")) {

            ps.setString(1, login);

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Client extractClientFromResultSet(ResultSet rs) throws SQLException {
        return new Client(
                rs.getString("login"),
                rs.getString("lastName"),
                rs.getString("firstName"),
                Client.Status.valueOf(rs.getString("status"))
        );
    }
}
