package com.globant.pod4.machines.servicesproducts.persistence.crud;

import com.globant.pod4.machines.servicesproducts.persistence.ProductRepository;
import com.globant.pod4.machines.servicesproducts.persistence.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j

class ProductCrudRepositoryTest {

   @Autowired
   private ProductRepository productRepository;



    @Test
    void shoud_return_a_product_list_from_repository(){

        List<Product> products = (List<Product>) productRepository.getAll();
        int productsNum = products.size();
        log.info("Actually we own " + productsNum + " products.");
        assertTrue(productsNum > 0);
    }

}