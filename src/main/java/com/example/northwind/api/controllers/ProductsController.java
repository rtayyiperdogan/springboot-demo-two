package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 20-May-21, Thu
 **/
@RestController
@RequestMapping("api/products")//   'localhost:api/products'
public class ProductsController {
    private ProductService productService;//API will speak with Business
    //IoC is running in background

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall") // 'localhost:api/products/getall'
    public List<Product> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Product product) {
        productService.add(product);
    }
    
    @PostMapping("/delete")
    public void delete(@RequestBody Product product) {
        productService.delete(product);
    }

}
