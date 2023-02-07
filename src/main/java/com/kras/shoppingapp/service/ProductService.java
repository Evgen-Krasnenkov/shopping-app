package com.kras.shoppingapp.service;

import com.kras.shoppingapp.model.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    List<Product> findAllByPriceBetween(BigDecimal from, BigDecimal to);
    List<Product> findAllProductsContain(String namePart);

    Product getById(long id);

    List<Product> getAllByCriteria(Map<String, String> params);

    void deleteById(Long id);

    Product updateProduct(Product product);

    List<Product> findAllByCategories(long from, long to);
}
