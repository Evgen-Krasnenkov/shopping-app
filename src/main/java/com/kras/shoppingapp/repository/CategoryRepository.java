package com.kras.shoppingapp.repository;

import com.kras.shoppingapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Category update(Category category);
}
