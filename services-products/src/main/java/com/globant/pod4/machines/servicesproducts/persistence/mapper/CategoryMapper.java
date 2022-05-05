package com.globant.pod4.machines.servicesproducts.persistence.mapper;

import com.globant.pod4.machines.servicesproducts.domain.CategoryDomain;
import com.globant.pod4.machines.servicesproducts.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({@Mapping(source = "categoryId", target = "id"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "status", target = "active")})
    CategoryDomain toCategory(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategoryDomain(CategoryDomain categoryDomain);
}
