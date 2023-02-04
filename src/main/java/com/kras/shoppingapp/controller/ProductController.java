package com.kras.shoppingapp.controller;

import com.kras.shoppingapp.dto.ProductRequestDto;
import com.kras.shoppingapp.dto.ProductResponseDto;
import com.kras.shoppingapp.dto.mapper.ProductMapper;
import com.kras.shoppingapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productMapper.toResponseDto(
                productService.save(productMapper.toModel(productRequestDto)));
    }

    @GetMapping
    public List<ProductResponseDto> getAll(){
        return productService.findAll()
                .stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ProductResponseDto getById(@PathVariable Long id){
        return productMapper.toResponseDto(productService.getById(id));
    }

}
