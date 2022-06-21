package com.globant.pod4.machines.servicesproducts.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchase")
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id", nullable = false)
    private Integer purchaseId;

   @Column(name = "client_id")
   private String clientId;

   @Column(name = "date")
   private LocalDateTime date;

   @Column(name = "half_payment")
   private String halfPayment;

   @Column(name = "commentary")
   private String commentary;

   @Column(name = "status")
   private Boolean status;

   @Column(name = "seller_id")
   private Integer seller_id;

   @ManyToOne
   @JoinColumn(name = "id",insertable = false, updatable = false)
   private User user;

   @OneToMany(mappedBy = "purchase")
   private List<PurchasesProduct> purchasesProducts;




   
}
