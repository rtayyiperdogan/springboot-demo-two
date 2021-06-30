package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.core.utilities.results.SuccessDataResult;
import com.example.northwind.core.utilities.results.SuccessResult;
import com.example.northwind.dataAccess.abstracts.ProductDao;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 20-May-21, Thu
 **/
@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll()
                ,"Data listed");
    }

    @Override
    public DataResult<List<Product>> getAllPageable(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Data Added");
    }

    @Override
    public void delete(Product city) {
        this.productDao.delete(city);
    }

    @Override
    public DataResult<Product> getProductByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName)
                ,"Data listed");
    }

    @Override
    public DataResult<Product> getProductByProductNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.
                getByProductNameAndCategory_CategoryId(productName,categoryId),
                "Data listed with Name and Id");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.
                getByProductNameOrCategory_CategoryId(productName,categoryId),
                "Data listed with product name or category id");
    }

    @Override
    public DataResult<List<Product>> getProductByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<Product>(this.productDao.getByCategory_CategoryIdIn(categories),
                "Data listed According to category id");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameContains(productName));
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameStartsWith(productName));
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByNameAndCategory(productName, categoryId));
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails());
    }


}
