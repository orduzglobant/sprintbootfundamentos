package com.globant.pod4.machines.servicesproducts.domain.repository;

import com.globant.pod4.machines.servicesproducts.domain.ProductDomain;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<ProductDomain> getAll();
    Optional<List<ProductDomain>> getByCategory(int categoryId);
    Optional<List<ProductDomain>> getProductById(int productId);
    ProductDomain save(ProductDomain productMapper);
    void delete(int productId);
}
