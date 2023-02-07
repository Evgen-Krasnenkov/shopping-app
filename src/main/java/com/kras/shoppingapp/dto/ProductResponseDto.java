package com.kras.shoppingapp.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Data
@Component
public class ProductResponseDto {
    private Long id;
    private BigDecimal price;
    private String title;
    private Long categoryId;
}
