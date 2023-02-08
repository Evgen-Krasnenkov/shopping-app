package com.kras.shoppingapp.repository;

import com.kras.shoppingapp.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    //UPDATE shopping_app.categories SET name = 'newName' WHERE id = 1
    @Transactional
    @Modifying
    @Query("UPDATE Category c SET c.name = ?2 WHERE c.id = ?1")
    Integer update(Long id, String name);
}
