package service;

import data.daoImpl.ProductDao;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public static List<Product> getAllProducts() {
        return new ArrayList<>(new ProductDao().getAll());
    }
}
