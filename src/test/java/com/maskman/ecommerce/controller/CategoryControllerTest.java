package com.maskman.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import org.junit.jupiter.api.Test;

import com.maskman.ecommerce.service.CategoryService;

import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {

    private static final String BASE_URL = "/api/v1/category";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    void getAll_status_ok() throws Exception {

        when(categoryService.getAll()).thenReturn(EMPTY_LIST);

        ResultActions getResult = mockMvc.perform(get(BASE_URL));

        getResult.andExpect(status().isOk());
        getResult.andExpect(content().string("[]"));
    }
}
