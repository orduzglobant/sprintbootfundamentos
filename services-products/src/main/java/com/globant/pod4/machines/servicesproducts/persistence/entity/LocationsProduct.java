package com.globant.pod4.machines.servicesproducts.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "locations_products")
@Data
public class LocationsProduct {

     @EmbeddedId
     private LocationsProductPK id;

     @Column(name = "amount_stock")
     private BigDecimal amountStock;

     @Column(name = "sale_price")
     private BigDecimal salePrice;

     @ManyToOne
     @JoinColumn(name = "product_id", insertable = false, updatable = false)
     private Product product;

     @ManyToOne
     @JoinColumn(name = "locations_id", insertable = false, updatable = false)
     private Location location;


}
