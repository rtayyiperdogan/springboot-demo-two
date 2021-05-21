package com.example.northwind.dataAccess.abstracts;

import com.example.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 20-May-21, Thu
 **/
public interface ProductDao extends JpaRepository<Product,Integer> {}
