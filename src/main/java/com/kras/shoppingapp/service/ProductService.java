package com.kras.shoppingapp.service;

import com.kras.shoppingapp.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    List<Product> findAllByPriceBetween(BigDecimal from, BigDecimal to);
    List<Product> findAllProductsContain(String namePart);

}
