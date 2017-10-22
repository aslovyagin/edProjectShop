package data.daoImpl;

import data.DaoInterface;
import data.pool.ConnectionPool;
import model.Product;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ProductDao implements DaoInterface<Product, Integer> {
    private ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public Product get(Integer id) {
        try (Connection con = pool.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT id, title, price, description FROM product " +
                             "WHERE id = " + id)) {

            return rs.next()
                    ? extractProductFromResultSet(rs)
                    : null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Product> getAll() {
        try (Connection con = pool.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT id, title, price, description FROM product")) {

            Set<Product> products = new HashSet<>();
            while (rs.next())
                products.add(extractProductFromResultSet(rs));

            return products;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(Product product) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO product (title, price, description) " +
                             "VALUES (?, ?, ?)")) {

            ps.setString(1, product.getTitle());
            ps.setString(2, String.valueOf(product.getPrice()));
            ps.setString(3, product.getDescription());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Product product) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE user SET (title, price, description) = " +
                             "(?, ?, ?) WHERE id = " + product.getId())) {

            ps.setString(1, product.getTitle());
            ps.setString(2, String.valueOf(product.getPrice()));
            ps.setString(3, product.getDescription());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (Connection con = pool.getConnection();
             Statement stmt = con.createStatement()) {

            return stmt.executeUpdate("DELETE FROM product " +
                    "WHERE id = " + id) == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteAll() {
        try (Connection con = pool.getConnection();
             Statement stmt = con.createStatement()) {

            return stmt.executeUpdate("DELETE FROM product") == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Product extractProductFromResultSet(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getInt("price"),
                rs.getString("description")
        );
    }
}
