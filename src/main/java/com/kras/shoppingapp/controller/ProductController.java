package com.kras.shoppingapp.controller;

import com.kras.shoppingapp.dto.ProductRequestDto;
import com.kras.shoppingapp.dto.ProductResponseDto;
import com.kras.shoppingapp.dto.mapper.ProductMapper;
import com.kras.shoppingapp.model.Product;
import com.kras.shoppingapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
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

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto){
        Product product = productMapper.toModel(productRequestDto);
        Product updatedProduct = productService.updateProduct(product);
        return productMapper.toResponseDto(updatedProduct);
    }

    @GetMapping("/")
    public List<ProductResponseDto> findAllByPriceBetween(@RequestParam(value="from", required=true)long from, @RequestParam(value="to", required=true) BigDecimal to){
        List<Product> allByPriceBetween = productService.findAllByPriceBetween(BigDecimal.valueOf(from), to);
        return allByPriceBetween.stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/categories")
    public List<ProductResponseDto> findAllByCategories(@RequestParam(value="fromId", required=true)long from, @RequestParam(value="toId", required=true) long to){
        List<Product> allByPriceBetween = productService.findAllByCategories(from, to);
        return allByPriceBetween.stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }


}
