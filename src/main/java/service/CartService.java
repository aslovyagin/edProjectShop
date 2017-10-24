package service;

import data.daoImpl.CartDao;
import model.Cart;

public class CartService {

    public static Cart getOrder(String login) {
        return new CartDao().get(login);
    }

    public static double getTotalPrice(Cart cart) {
        return cart.getClientProducts().stream().mapToDouble(Cart.ClientProduct::getSum).sum();
    }

    public static int getTotalCount(Cart cart) {
        return cart.getClientProducts().stream().mapToInt(Cart.ClientProduct::getCount).sum();
    }
}
