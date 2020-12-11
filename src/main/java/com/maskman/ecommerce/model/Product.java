package com.maskman.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Short description has to be provided")
    @Size(min = 2, max = 140, message = "Short description must be between 2 and 140 characters")
    private String shortDescription;

    @Size(max = 1000)
    private String longDescription;

    @Positive(message = "Price can not be negative")
    private Double price;
}
