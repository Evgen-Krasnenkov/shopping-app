package com.kras.shoppingapp.controller;

import com.kras.shoppingapp.dto.ProductResponseDto;
import com.kras.shoppingapp.dto.mapper.ProductMapper;
import com.kras.shoppingapp.model.Category;
import com.kras.shoppingapp.model.Product;
import com.kras.shoppingapp.service.ProductServiceImpl;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @MockBean
    private ProductServiceImpl productService;
    @MockBean
    private ProductMapper productMapper;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void findAllProductOK() {
        Category category1 = new Category(1L, "Phones");
        Category category2 = new Category(2L, "Tablets");
        Category category3 = new Category(1L, "Phones");
        Product product1 = new Product(41L, "iPhoneX" , BigDecimal.valueOf(999), category1);
        Product product2 = new Product(42L, "iPhone11", BigDecimal.valueOf(1199), category2);
        Product product3 = new Product(43L, "iPhone13", BigDecimal.valueOf(1299), category3);
        ProductResponseDto responseDto = ProductResponseDto.builder()
                .id(43L)
                .title("iPhoneX")
                .price(BigDecimal.valueOf(999))
                .categoryId(1L)
                .build();
        List<ProductResponseDto> dtos = List.of(responseDto);
        List<Product> products = List.of(product1);
        Mockito.when(productService.findAll()).thenReturn(products);
        Mockito.doReturn(responseDto).when(productMapper).toResponseDto(product1);
        RestAssuredMockMvc.when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("size()", Matchers.equalTo(1))
                .body("[0].id", Matchers.equalTo(43))
                .body("[0].title", Matchers.equalTo("iPhoneX"));
    }
}