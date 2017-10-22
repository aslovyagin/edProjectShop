package data.daoImpl;

import data.ConnectionFactory;
import data.DaoInterface;
import model.Order;
import util.OrderStatus;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class OrderDao implements DaoInterface<Order,Integer> {
    @Override
    public Order get(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM order WHERE orderId=" + id);
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Order> getAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM order");
            Set orders = new HashSet();
            while (rs.next()) {
                Order order = extractUserFromResultSet(rs);
                orders.add(order);
            }
            return orders;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Order order) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO client VALUES (NULL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getClientId());
            ps.setInt(2, order.getTotalPrice());
            ps.setString(3, order.getStatus().toString());
            int i = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean update(Order order) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE order SET cleintId=?, totalPrice=?, status=? WHERE id=?");
            ps.setInt(1, order.getClientId());
            ps.setInt(2, order.getTotalPrice());
            ps.setString(3, order.getStatus().toString());
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
            int i = stmt.executeUpdate("DELETE FROM order WHERE orderId=" + id);
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
            int i = stmt.executeUpdate("DELETE  FROM order");
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private Order extractUserFromResultSet(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("orderId"));
        order.setClientId(rs.getInt("clientId"));
        order.setTotalPrice(rs.getInt("totalPrice"));
        order.setStatus(OrderStatus.valueOf(rs.getString("status")));

        return order;
    }
}
