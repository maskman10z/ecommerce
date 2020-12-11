package com.maskman.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.maskman.ecommerce.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
