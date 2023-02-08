package com.kras.shoppingapp.dto.mapper;

import com.kras.shoppingapp.dto.CategoryRequestDto;
import com.kras.shoppingapp.dto.CategoryResponseDto;
import com.kras.shoppingapp.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    private CategoryResponseDto categoryResponseDto;

    public CategoryMapper(CategoryResponseDto categoryResponseDto) {
        this.categoryResponseDto = categoryResponseDto;
    }

    public Category toModel(CategoryRequestDto categoryRequestDto){
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        return category;
    }

    public CategoryResponseDto toDto(Category category) {
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());
        return categoryResponseDto;
    }
}
