package com.maskman.ecommerce.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maskman.ecommerce.model.Product;
import com.maskman.ecommerce.service.ProductService;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    //TODO set correct response codes. See: https://docs.spring.io/spring-data/rest/docs/current/reference/html/#
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> get() {

        return productService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Product get(@PathVariable long id) {

        return productService.get(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Product create(@RequestBody Product product) {

        return productService.save(product);
    }

    @PutMapping(value = "/{id}")
    public Product update(@PathVariable("id") Long id, @RequestBody Product product) { // should return 201 if created a new, currently 200

        product.setId(id);
        return productService.save(product);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {

        productService.delete(id);
    }
}
