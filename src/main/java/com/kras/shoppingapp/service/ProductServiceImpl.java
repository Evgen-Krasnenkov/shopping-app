package com.kras.shoppingapp.service;

import com.kras.shoppingapp.model.Product;
import com.kras.shoppingapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllByPriceBetween(BigDecimal from, BigDecimal to) {
        return productRepository.findAllByPriceBetween(from, to);
    }

    @Override
    public List<Product> findAllProductsContain(String namePart) {
        return productRepository.findAllProductsContain(namePart);
    }

    @Override
    public Product getById(long id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getAllByCriteria(Map<String, String> params) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product){
        Integer updateProduct = productRepository.updateProduct(product.getId(), product.getTitle(),
                product.getPrice(), product.getCategory());
        return productRepository.getReferenceById(Long.valueOf(updateProduct));
    }

    @Override
    public List<Product> findAllByCategories(long from, long to) {
        return productRepository.findAllByCategories(from, to);
    }

    @Override
    public List<String> getProductsToUpperCase() {
        return productRepository.findAll().stream()
                .map(product -> product.getTitle().toUpperCase())
                .collect(Collectors.toList());
    }
}
