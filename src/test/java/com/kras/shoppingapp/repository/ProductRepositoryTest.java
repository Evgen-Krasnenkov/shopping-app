package com.kras.shoppingapp.repository;

import com.kras.shoppingapp.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE )
class ProductRepositoryTest {
    @Container
    static MySQLContainer<?> database = new MySQLContainer<>("mysql:8")
            .withDatabaseName("springboot")
            .withPassword("springboot")
            .withUsername("springboot");

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry propertyRegistry){
        propertyRegistry.add("spring.datasource.url", database::getJdbcUrl);
        propertyRegistry.add("spring.datasource.password", database::getPassword);
        propertyRegistry.add("spring.datasource.username", database::getUsername);
    }
    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Sql("/scripts/insertProducts.sql")
    void findAllByPriceBetweenOK() {
        List<Product> allByPriceBetween =
                productRepository.findAllByPriceBetween(BigDecimal.valueOf(1200), BigDecimal.valueOf(1300));
        Assertions.assertEquals(1, allByPriceBetween.size());
    }

    @Test
    void findAllProductsContainOK() {
        List<Product> x = productRepository.findAllProductsContain("iPhoneX");
        Assertions.assertEquals(1, x.size());
    }
//
//    @Test
//    void updateProduct() {
//    }
//
//    @Test
//    void findAllByCategories() {
//    }
}