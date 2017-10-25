package data.daoImpl;

import data.ConnectionFactory;
import data.DaoInterface;
import model.Client;
import model.Product;
import util.Status;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ClientDAO implements DaoInterface<Client, Integer> {

    @Override
    public Client get(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE id=" + id);
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Client> getAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client");
            Set clients = new HashSet();
            while (rs.next()) {
                Client client = extractUserFromResultSet(rs);
                clients.add(client);
            }
            return clients;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Client client) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO client VALUES (NULL, ?, ?, ?, ?)");
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getSurName());
            ps.setString(3, client.getStatus().toString());
            ps.setString(4, client.getAdress());
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
    public boolean update(Client client) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE client SET firstName=?, surName=?, status=?, adress=? WHERE id=?");
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getSurName());
            ps.setString(3, client.getStatus().toString());
            ps.setString(4, client.getAdress());
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
    public boolean delete(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM client WHERE id=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE  FROM client");
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private Client extractUserFromResultSet(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setId(rs.getInt("id"));
        client.setFirstName(rs.getString("firstName"));
        client.setSurName(rs.getString("surName"));
        client.setAdress(rs.getString("adress"));
        client.setStatus(Status.valueOf(rs.getString("status")));
        return client;
    }

}
