package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 20-May-21, Thu
 **/
@RestController
@RequestMapping(value = "/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getAllPageable")
    DataResult<List<Product>> getAllPageable(int pageNo, int pageSize){
        return this.productService.getAllPageable(pageNo,pageSize);
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }
    
    @PostMapping("/delete")
    public void delete(@RequestBody Product product) {
        productService.delete(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getProductByProductName(productName);

    }

    @GetMapping("/getProductByProductNameAndCategory")
    public DataResult<Product> getProductByProductNameAndCategory(@RequestParam(name =
            "productName") String productName, @RequestParam(name = "categoryId")int categoryId){
        return this.productService.getProductByProductNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategory")
    public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName,
                                                                  @RequestParam int categoryId){
        return this.productService.getByProductNameOrCategory(productName, categoryId);
    }

    @GetMapping("/getProductByCategoryIn")
    public DataResult<List<Product>> getProductByCategoryIn(@RequestParam List<Integer> categories){
        return this.productService.getProductByCategoryIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,
                                                                @RequestParam int categoryId){
        return this.productService.getByNameAndCategory(productName, categoryId);
    }

}
