package com.globant.pod4.machines.servicesproducts.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String surnames;

    @Column(name = "cell_phone")
    private Integer cellPhone;

    private String address;
    private String email;

    @Column(name = "photo_url")
    private String photoUrl;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Purchase> purchases;


}
