package com.globant.pod4.machines.servicesproducts.persistence;

import com.globant.pod4.machines.servicesproducts.persistence.crud.ProductCrudRepository;
import com.globant.pod4.machines.servicesproducts.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){

        return (List<Product>) productCrudRepository.findAll();
    }

    public Optional<Product> getProductById(int productId){
        return productCrudRepository.findById(productId);
    }

    public Product save(Product product){
        return productCrudRepository.save(product);

    }

    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }

    public List<Product> getByCategoryId(int id){
        return productCrudRepository.findByCategoryIdIs(id);
    }
}
