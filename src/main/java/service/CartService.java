package service;

import data.daoImpl.CartDao;
import model.Cart;

public class CartService {

    public static Cart getCart(String login) {
        return new CartDao().getCurrentCartByLogin(login);
    }

    public static int getCurrentCartId(String login) {
        return new CartDao().getCurrentCartIdByLogin(login);
    }


    public static double getTotalPrice(Cart cart) {
        return cart.getClientProducts().stream().mapToDouble(Cart.ClientProduct::getSum).sum();
    }

    public static int getTotalCount(Cart cart) {
        return cart.getClientProducts().stream().mapToInt(Cart.ClientProduct::getCount).sum();
    }

    public static void createCartByLogin(String login) {
        new CartDao().createCartByLogin(login);
    }

    public static void addProductToCart(String login, int productId) {
        int cartId = getCurrentCartId(login);
        new CartDao().addProductToCart(cartId, productId, 1);
    }

    public static void incrementProduct(String login, int productId) {
        int cartId = getCurrentCartId(login);
        new CartDao().incrementProduct(cartId, productId);
    }

    public static void decrementProduct(String login, int productId) {
        int cartId = getCurrentCartId(login);
        new CartDao().decrementProduct(cartId, productId);
    }

}
