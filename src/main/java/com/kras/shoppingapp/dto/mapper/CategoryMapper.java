package com.kras.shoppingapp.dto.mapper;

import com.kras.shoppingapp.dto.CategoryRequestDto;
import com.kras.shoppingapp.dto.CategoryResponseDto;
import com.kras.shoppingapp.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    private Category category;
    private CategoryResponseDto categoryResponseDto;

    public CategoryMapper(Category category, CategoryResponseDto categoryResponseDto) {
        this.category = category;
        this.categoryResponseDto = categoryResponseDto;
    }

    public Category toModel(CategoryRequestDto categoryRequestDto){
        category.setName(categoryRequestDto.getName());
        return category;
    }

    public CategoryResponseDto toDto(Category category) {
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());
        return categoryResponseDto;
    }
}
