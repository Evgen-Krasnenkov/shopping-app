package com.kras.shoppingapp.repository;

import com.kras.shoppingapp.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
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

import java.util.List;

@DataJpaTest
@Testcontainers(disabledWithoutDocker = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EnabledIf("isDockerRunning")
class CategoryRepositoryTest {
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
    private CategoryRepository categoryRepository;

    @Test
    @Sql("/scripts/insertProducts.sql")
    void getAllOK(){
        List<Category> all = categoryRepository.findAll();
        Assertions.assertEquals(2, all.size());
    }

    @Test
    @Sql("/scripts/insertProducts.sql")
    void updateCategory(){
        long supersmartId = Long.valueOf(categoryRepository.update(1L, "Smartphone"));
        Category referenceById = categoryRepository.getReferenceById(supersmartId);
        Assertions.assertEquals("Smartphone", referenceById.getName());
    }
}