package com.kras.shoppingapp.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CategoryResponseDto {
    private Long id;
    private String name;
}
