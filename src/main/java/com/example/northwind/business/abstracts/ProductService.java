package com.example.northwind.business.abstracts;

import com.example.northwind.entities.concretes.Product;

import java.util.List;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 20-May-21, Thu
 **/
public interface ProductService {
    List<Product> getAll();
    void add(Product city);
    void delete(Product city);

}
