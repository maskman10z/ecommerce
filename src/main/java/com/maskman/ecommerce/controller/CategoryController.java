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

import javax.validation.Valid;

import com.maskman.ecommerce.model.Category;
import com.maskman.ecommerce.service.CategoryService;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping
    public Iterable<Category> get() {

        return categoryService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Category get(@PathVariable Long id) {

        return categoryService.get(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Category create(@Valid @RequestBody Category category) {

        return categoryService.save(category);
    }

    @PutMapping(value = "/{id}")
    public Category update(@Valid @PathVariable Long id, Category category) {

        category.setId(id);
        return categoryService.save(category);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id) {

        categoryService.delete(id);
    }
}
