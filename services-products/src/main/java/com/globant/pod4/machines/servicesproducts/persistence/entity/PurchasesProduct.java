package com.globant.pod4.machines.servicesproducts.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "purchase_products")
@Data
public class PurchasesProduct {

    @EmbeddedId
    private PurchasesProductPK id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "purchase_id", insertable = false, updatable = false)
    private Purchase purchase;

}
