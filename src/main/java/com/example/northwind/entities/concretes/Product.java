package com.example.northwind.entities.concretes;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 20-May-21, Thu
 **/
@Data //Lombok
@Entity
@Table(name="products")
public class Product {
    @Id//primaryKeyId Annotation
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)//AutoIncrement
    private int id;

    @Column(name="category_id")
    private int categoryId;

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private int unitsInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    public Product(int id, int categoryId,
                   String productName, double unitPrice,
                   int unitsInStock, String quantityPerUnit) {
        this.id = id;
        this.categoryId = categoryId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.quantityPerUnit = quantityPerUnit;
    }
    //This constructor for hibernate? Ask to Taylan abi
    public Product() {
    }
}
