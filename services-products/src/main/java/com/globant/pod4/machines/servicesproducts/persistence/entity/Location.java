package com.globant.pod4.machines.servicesproducts.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locations_id")
    private Integer locationsId;

    @Column(name = "locations_name")
    private String locationsName;

    @Column(name = "locations_email")
    private String locationsEmail;

    @OneToMany(mappedBy = "location")
    private List<LocationsProduct> locationsProducts;
}
