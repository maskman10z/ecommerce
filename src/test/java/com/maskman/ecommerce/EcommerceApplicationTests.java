package com.maskman.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;

import com.maskman.ecommerce.controller.ProductController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EcommerceApplicationTests {

    @Autowired
    private ProductController productController;

    @Test
    void contextLoads() {

        assertThat(productController).isNotNull();
    }
}
