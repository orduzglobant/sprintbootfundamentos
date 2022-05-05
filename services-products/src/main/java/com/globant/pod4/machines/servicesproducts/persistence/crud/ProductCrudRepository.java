package com.globant.pod4.machines.servicesproducts.persistence.crud;

import com.globant.pod4.machines.servicesproducts.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<Product,Integer> {

    List<Product> findByCategoryIdIs(int categoryId);


}
