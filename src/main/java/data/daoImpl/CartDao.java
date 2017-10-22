package data.daoImpl;

import data.DaoInterface;
import model.Cart;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Set;

public class CartDao implements DaoInterface<Cart, String> {

    @Override
    public Cart get(String login) {
        throw new NotImplementedException("");
    }

    @Override
    public Set<Cart> getAll() {
        throw new NotImplementedException("");
    }

    @Override
    public boolean insert(Cart item) {
        throw new NotImplementedException("");
    }

    @Override
    public boolean update(Cart item) {
        throw new NotImplementedException("");
    }

    @Override
    public boolean delete(String id) {
        throw new NotImplementedException("");
    }
}
