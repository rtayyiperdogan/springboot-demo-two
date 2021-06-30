package com.example.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 30-Jun-21, Wed
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
    private int productId;
    private String productName;
    private String categoryName;
}
