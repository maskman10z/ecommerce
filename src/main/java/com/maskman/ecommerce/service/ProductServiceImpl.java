package com.maskman.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.maskman.ecommerce.model.Product;
import com.maskman.ecommerce.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAll() {

        return productRepository.findAll();
    }

    @Override
    public Product get(long id) {

        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Product with id: {0} not found", id)));
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {

        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Product with id: {0} not found.", id))));
    }
}
