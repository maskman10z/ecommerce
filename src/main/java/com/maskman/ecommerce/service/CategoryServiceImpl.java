package com.maskman.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;

import javax.persistence.EntityNotFoundException;

import com.maskman.ecommerce.model.Category;
import com.maskman.ecommerce.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> getAll() {

        return categoryRepository.findAll();
    }

    @Override
    public Category get(long id) {

        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Category with id: {0} not found.", id)));
    }

    @Override
    public Category save(Category product) {

        return categoryRepository.save(product);
    }

    @Override
    public void delete(Long id) {

        categoryRepository.delete(get(id));
    }
}
