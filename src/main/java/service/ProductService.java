package service;

import data.daoImpl.ProductDao;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public static List<Product> getAllProducts() {
        return new ArrayList<>(new ProductDao().getAll());
    }

    public static void add(String title, double price, String description) {
        new ProductDao().insert(new Product(0, title, price, description));
    }

    public static void update(int id, String title, double price, String description) {
        new ProductDao().update(new Product(id, title, price, description));
    }

    public static void delete(int id) {
        new ProductDao().delete(id);
    }

    public static Product get(int productId) {
        return new ProductDao().get(productId);
    }
}
