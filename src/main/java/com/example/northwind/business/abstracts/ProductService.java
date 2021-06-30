package com.example.northwind.business.abstracts;

import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;


import java.util.List;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 20-May-21, Thu
 **/
public interface ProductService {
    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAllPageable(int pageNo, int pageSize);

    Result add(Product product);

    void delete(Product city);

    DataResult<Product> getProductByProductName(String productName);

    DataResult<Product> getProductByProductNameAndCategory(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

    DataResult<List<Product>> getProductByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
