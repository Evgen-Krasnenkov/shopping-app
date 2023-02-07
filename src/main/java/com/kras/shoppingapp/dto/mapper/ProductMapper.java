package com.kras.shoppingapp.dto.mapper;

import com.kras.shoppingapp.dto.ProductRequestDto;
import com.kras.shoppingapp.dto.ProductResponseDto;
import com.kras.shoppingapp.model.Product;
import com.kras.shoppingapp.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    private final ProductResponseDto productResponseDto;
    private final Product product;
    private final CategoryService categoryService;

    public ProductMapper(ProductResponseDto productResponseDto, Product product, CategoryService categoryService) {
        this.productResponseDto = productResponseDto;
        this.product = product;
        this.categoryService = categoryService;
    }

    public Product toModel(ProductRequestDto productRequestDto){
        product.setPrice(productRequestDto.getPrice());
        product.setTitle(productRequestDto.getTitle());
        product.setCategory(categoryService.getById(productRequestDto.getCategoryId()));
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
