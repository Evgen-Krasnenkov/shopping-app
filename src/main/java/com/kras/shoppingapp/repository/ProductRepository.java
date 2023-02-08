package com.kras.shoppingapp.repository;

import com.kras.shoppingapp.model.Category;
import com.kras.shoppingapp.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    @Transactional
    @Modifying
    @Query("update Product p set p.title = ?2, p.price = ?3, p.category = ?4 where p.id = ?1")
    Integer updateProduct(Long id, String title, BigDecimal price, Category category);

    @Query(value = "select p from Product p join Category c on c.id = p.category.id where c.id between ?1 and ?2")
    List<Product> findAllByCategories(long from, long to);
}
