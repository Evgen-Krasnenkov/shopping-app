package com.kras.shoppingapp.dto.mapper;

import com.kras.shoppingapp.dto.ProductRequestDto;
import com.kras.shoppingapp.dto.ProductResponseDto;
import com.kras.shoppingapp.model.Category;
import com.kras.shoppingapp.model.Product;
import com.kras.shoppingapp.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    private final ProductResponseDto productResponseDto;
    private final CategoryService categoryService;

    public ProductMapper(ProductResponseDto productResponseDto, CategoryService categoryService) {
        this.productResponseDto = productResponseDto;
        this.categoryService = categoryService;
    }

    public Product toModel(ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setPrice(productRequestDto.getPrice());
        product.setTitle(productRequestDto.getTitle());
        Category category = categoryService.getById(productRequestDto.getCategoryId());
        product.setCategory(category);
        return product;
    }
    public ProductResponseDto toResponseDto(Product product){
        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setCategoryId(product.getCategory().getId());
        return productResponseDto;
    }
}
