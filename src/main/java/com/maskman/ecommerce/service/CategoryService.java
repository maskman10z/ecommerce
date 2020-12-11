package com.maskman.ecommerce.service;

import com.maskman.ecommerce.model.Category;

public interface CategoryService {

    public Iterable<Category> getAll();

    public Category get(long id);

    public Category save(Category product);

    public void delete(Long id);
}
