package com.kras.shoppingapp.dto.mapper;

import com.kras.shoppingapp.dto.ProductRequestDto;
import com.kras.shoppingapp.dto.ProductResponseDto;
import com.kras.shoppingapp.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    private final ProductResponseDto productResponseDto;
    private final Product product;

    public ProductMapper(ProductResponseDto productResponseDto, Product product) {
        this.productResponseDto = productResponseDto;
        this.product = product;
    }

    public Product toModel(ProductRequestDto productRequestDto){
        product.setPrice(productRequestDto.getPrice());
        product.setTitle(productRequestDto.getTitle());
        return product;
    }
    public ProductResponseDto toResponseDto(Product product){
        //ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setPrice(product.getPrice());
        return productResponseDto;
    }
}
