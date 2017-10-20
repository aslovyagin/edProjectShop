package data.daoImpl;

import data.DaoInterface;
import data.pool.ConnectionPool;
import model.Product;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ProductDao implements DaoInterface<Product, Integer> {
    ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public Product get(Integer id) {
        Connection connection = pool.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM product WHERE id=" + id);
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Product> getAll() {
        Connection connection = pool.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM product");
            Set products = new HashSet();
            while (rs.next()) {
                Product product = extractUserFromResultSet(rs);
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Product product) {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO product VALUES (NULL, ?, ?, ?)");
            ps.setInt(1, product.getPrice());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
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
    public boolean update(Product product) {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET price=?, name=?, description=? WHERE id=?");
            ps.setInt(1, product.getPrice());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setInt(4, product.getId());
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
        Connection connection = pool.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM product WHERE id=" + id);
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
            int i = stmt.executeUpdate("DELETE  FROM product");
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private Product extractUserFromResultSet(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getInt("price"));
        product.setDescription(rs.getString("description"));
        return product;
    }
}
