package com.kras.shoppingapp.service;

import com.kras.shoppingapp.model.Category;
import com.kras.shoppingapp.model.Product;
import com.kras.shoppingapp.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;

    @Test
    void getProductsToUpperCaseOK() {

        Mockito.when(productRepository.findAll())
                .thenReturn(List.of(new Product(1L, "iPhone", BigDecimal.valueOf(1200), new Category())));
        List<String> productsToUpperCase = productService.getProductsToUpperCase();
        Assertions.assertEquals(1, productsToUpperCase.size());
        Assertions.assertEquals("IPHONE", productsToUpperCase.get(0));
    }
}