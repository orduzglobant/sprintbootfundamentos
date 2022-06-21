package com.globant.pod4.machines.servicesproducts.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class LocationsProductPK implements Serializable {

    @Column(name = "locations_locations_id")
    private Integer locationsLocationsId;

    @Column(name = "products_product_id")
    private Integer productsProductId;
}
