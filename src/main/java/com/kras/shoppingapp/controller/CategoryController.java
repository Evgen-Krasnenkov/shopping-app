package com.kras.shoppingapp.controller;

import com.kras.shoppingapp.dto.CategoryRequestDto;
import com.kras.shoppingapp.dto.CategoryResponseDto;
import com.kras.shoppingapp.dto.mapper.CategoryMapper;
import com.kras.shoppingapp.model.Category;
import com.kras.shoppingapp.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getById(@PathVariable Long id){
        return categoryMapper.toDto(categoryService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
    }

//    @PutMapping("/{id}")
//    public CategoryResponseDto update(@PathVariable Long id, @RequestBody CategoryRequestDto categoryRequestDto){
//        Category category = categoryMapper.toModel(categoryRequestDto);
//        category.setId(id);
//        return categoryMapper.toDto(categoryService.update(category));
//    }
}
