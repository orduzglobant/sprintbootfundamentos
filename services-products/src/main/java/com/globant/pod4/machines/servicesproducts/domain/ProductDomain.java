package com.globant.pod4.machines.servicesproducts.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDomain {

    private int id;
    private String name;
    private int category;
    private BigDecimal salePrice;
    private Integer amount;
    private Boolean active;
    private Integer brand;
    private String model;

}
