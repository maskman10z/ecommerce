package com.maskman.ecommerce.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maskman.ecommerce.model.Product;
import com.maskman.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    //TODO set correct response codes. See: https://docs.spring.io/spring-data/rest/docs/current/reference/html/#
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> get() { // should return 200

        return productService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Product get(@PathVariable long id) { // should return 200 or 404

        return productService.get(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) { // should return 201

        return productService.save(product);
    }

    @PutMapping(value = "/{id}")
    public Product update(@PathVariable("id") Long id, @RequestBody Product product) { // should return 201 if created a new

        product.setId(id);
        return productService.save(product);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) { // should return 204

        productService.delete(id);
    }
}
