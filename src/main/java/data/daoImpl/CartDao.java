package data.daoImpl;

import data.pool.ConnectionPool;
import model.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private ConnectionPool pool = ConnectionPool.getInstance();

    public Cart getCurrentCartByLogin(String login) {
        Integer currentCartIdByLogin = getCurrentCartIdByLogin(login);

        return (currentCartIdByLogin != -1)
                ? getCartById(currentCartIdByLogin)
                : new Cart(new ArrayList<>());
    }

    public int getCurrentCartIdByLogin(String login) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT MAX(id) id FROM cart WHERE login = ?")) {

            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            return rs.next()
                    ? rs.getInt("id")
                    : -1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cart getCartById(Integer cartId) {
        try (Connection con = pool.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT product_id, product_count FROM cart_product " +
                             "WHERE cart_id = " + cartId)) {

            return extractOrderFromResultSet(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Cart extractOrderFromResultSet(ResultSet rs) throws SQLException {

        List<Cart.ClientProduct> clientProducts = new ArrayList<>();

        while (rs.next())
            clientProducts.add(
                    new Cart.ClientProduct(
                            new ProductDao().get(rs.getInt("product_id")),
                            rs.getInt("product_count")
                    ));

        return new Cart(clientProducts);
    }

    public boolean createCartByLogin(String login) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO cart (login) VALUES (?)")) {

            ps.setString(1, login);
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addProductToCart(int cartId, int productId, int productCount) {
        try (Connection con = pool.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO cart_product (cart_id, product_id, product_count) " +
                             "VALUES (?, ?, ?)")) {

            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            ps.setInt(3, productCount);
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean incrementProduct(int cartId, int productId) {
        try (Connection con = pool.getConnection();
             Statement stmt = con.createStatement()) {

            return stmt.executeUpdate(
                    "UPDATE cart_product SET product_count = product_count + 1 " +
                            "WHERE cart_id = " + cartId + " AND product_id = " + productId) == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean decrementProduct(int cartId, int productId) {

        if (getProductCount(cartId, productId) < 1)
            return false;

        try (Connection con = pool.getConnection();
             Statement stmt = con.createStatement()) {

            return stmt.executeUpdate(
                    "UPDATE cart_product SET product_count = product_count - 1 " +
                            "WHERE cart_id = " + cartId + " AND product_id = " + productId) == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getProductCount(int cartId, int productId) {
        try (Connection con = pool.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT product_count FROM cart_product " +
                             "WHERE cart_id = " + cartId + " AND product_id = " + productId)) {

            return rs.next()
                    ? rs.getInt("product_count")
                    : -1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
