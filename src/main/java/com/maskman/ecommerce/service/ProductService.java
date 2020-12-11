package com.maskman.ecommerce.service;

import com.maskman.ecommerce.model.Product;

public interface ProductService {

    public Iterable<Product> getAll();

    public Product get(long id);

    public Product save(Product product);

    public void delete(Long id);
}
