package com.globant.pod4.machines.servicesproducts.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "amount_stock")
    private Integer amountStock;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "model")
    private String model;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<PurchasesProduct> purchases;


    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<LocationsProduct> locations;


}
