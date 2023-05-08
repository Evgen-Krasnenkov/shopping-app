package com.kras.shoppingapp.repository;

import com.kras.shoppingapp.model.Category;
import com.kras.shoppingapp.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.EnabledIf;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE )
@Testcontainers(disabledWithoutDocker = true)
class ProductRepositoryTest {
    @Container
    static MySQLContainer<?> database = new MySQLContainer<>("mysql:8")
            .withDatabaseName("springboot")
            .withPassword("springboot")
            .withUsername("springboot");

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry propertyRegistry){
        propertyRegistry.add("spring.datasource.url", () -> database.getJdbcUrl());
        propertyRegistry.add("spring.datasource.password", database::getPassword);
        propertyRegistry.add("spring.datasource.username", () -> database.getUsername());
    }
    @Autowired
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    @Sql("/scripts/insertProducts.sql")
    void findAllByPriceBetweenOK() {
        List<Product> allByPriceBetween =
                productRepository.findAllByPriceBetween(BigDecimal.valueOf(1200), BigDecimal.valueOf(1300));
        Assertions.assertEquals(1, allByPriceBetween.size());
    }

    @Test
    @Sql("/scripts/insertProducts.sql")
    void findAllProductsContainOK() {
        List<Product> x = productRepository.findAllProductsContain("iPhoneX");
        Assertions.assertEquals(2, x.size());
    }

    @Test
    @Sql("/scripts/insertProducts.sql")
    void updateProduct() {
        Mockito.when(categoryRepository.getReferenceById(1l)).thenReturn( new Category(1L, "random"));
        Category referenceById1 = categoryRepository.getReferenceById(1l);
        Long newIphoneX = Long.valueOf(productRepository.
                updateProduct(1L, "NewIphoneX", BigDecimal.valueOf(1005), referenceById1));
        Product referenceById = productRepository.getReferenceById(newIphoneX);
        Assertions.assertEquals("NewIphoneX", referenceById.getTitle());
    }
//TODO
//    @Test
//    void findAllByCategories() {
//    }
}