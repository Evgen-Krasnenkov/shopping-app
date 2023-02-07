package com.kras.shoppingapp.service;

import com.kras.shoppingapp.model.Category;

public interface CategoryService {
    Category getById(Long id);
    Category create(Category category);
    void deleteById(Long id);
//    Category update(Category category);

}
