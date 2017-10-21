package service;

import data.daoImpl.ProductDao;

import java.util.Set;

public class ProductService {

    public static Set getAllProducts()
    {
        return new ProductDao().getAll();
    }
}
