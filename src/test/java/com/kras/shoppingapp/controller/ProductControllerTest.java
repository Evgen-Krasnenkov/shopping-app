package com.kras.shoppingapp.controller;

import com.kras.shoppingapp.model.Category;
import com.kras.shoppingapp.model.Product;
import com.kras.shoppingapp.service.ProductServiceImpl;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)

class ProductControllerTest {
    @MockBean
    private ProductServiceImpl productService;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void findAllProductOK() {
        List<Product> mockProducts = List.of(
          new Product(41L, "iPhoneX", BigDecimal.valueOf(999), new Category(1L, "Phones")),
          new Product(42L, "iPhone11", BigDecimal.valueOf(1199), new Category(2L, "Tablets")),
          new Product(43L, "iPhone13", BigDecimal.valueOf(1299), new Category(1L, "Phones"))
        );
        Mockito.when(productService.findAll()).thenReturn(mockProducts);
        RestAssuredMockMvc.when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("size()", Matchers.equalTo(3))
                .body("[0].id", Matchers.equalTo(43))
                .body("[1].title", Matchers.equalTo("iPhone13"));
    }
}