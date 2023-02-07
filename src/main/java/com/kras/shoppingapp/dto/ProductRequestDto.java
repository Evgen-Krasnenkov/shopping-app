package com.kras.shoppingapp.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDto {
    private BigDecimal price;
    private String title;
    private Long categoryId;
}
