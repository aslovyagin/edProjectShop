package data.daoImpl;

import data.DaoInterface;
import model.Order;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Set;

public class CartDao implements DaoInterface<Order, String> {

    @Override
    public Order get(String login) {
        throw new NotImplementedException("");
    }

    @Override
    public Set<Order> getAll() {
        throw new NotImplementedException("");
    }

    @Override
    public boolean insert(Order item) {
        throw new NotImplementedException("");
    }

    @Override
    public boolean update(Order item) {
        throw new NotImplementedException("");
    }

    @Override
    public boolean delete(String id) {
        throw new NotImplementedException("");
    }
}
