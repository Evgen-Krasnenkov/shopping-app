package com.kras.shoppingapp.repository;

import com.kras.shoppingapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceBetween(BigDecimal from, BigDecimal to);
    @Query(value = "select p from Product p where p.title like %:name%")
    List<Product> findAllProductsContain(@Param("name") String name);
}
