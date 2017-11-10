package com.andkantor.snowfox.product.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.andkantor.snowfox.product.model.Product;

@RepositoryRestResource(collectionResourceRel = "items", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
