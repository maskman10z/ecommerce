package com.maskman.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.maskman.ecommerce.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
