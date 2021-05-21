package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.dataAccess.abstracts.ProductDao;
import com.example.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 20-May-21, Thu
 **/
@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired//for Injection.This create SessionFactory
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }

    @Override
    public void add(Product product) {
        this.productDao.save(product);
    }

    @Override
    public void delete(Product city) {
        this.productDao.delete(city);
    }

}
