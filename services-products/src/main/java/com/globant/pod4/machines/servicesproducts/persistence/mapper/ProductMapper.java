package com.globant.pod4.machines.servicesproducts.persistence.mapper;

import com.globant.pod4.machines.servicesproducts.persistence.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({@Mapping(source = "productId",target = "id"),
               @Mapping(source = "name",target = "name"),
                @Mapping(source = "categoryId",target = "category"),
                @Mapping(source = "salePrice",target = "salePrice"),
                @Mapping(source = "amountStock",target = "amount"),
                @Mapping(source = "status",target = "active"),
            @Mapping(source = "status",target = "active")})
    ProductMapper toProduct(Product product);

}
