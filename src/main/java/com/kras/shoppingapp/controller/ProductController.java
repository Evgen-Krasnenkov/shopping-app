package com.kras.shoppingapp.controller;

import com.kras.shoppingapp.model.Product;
import com.kras.shoppingapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/inject")
    public List<Product> saveProduct() {
        for (int i = 0; i < 100; i += 10) {
            Product product = new Product();
            product.setTitle("iPhone" + i);
            product.setPrice(BigDecimal.valueOf(1399 + 10 * i));
            productService.save(product);
        }
        return productService.findAll();
    }

    @GetMapping("/products")
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/products/")
    public List<Product> findAllByPriceBetween(@RequestParam(value="from", required=true)long from, @RequestParam(value="to", required=true) BigDecimal to){
        List<Product> allByPriceBetween = productService.findAllByPriceBetween(BigDecimal.valueOf(from), to);
        allByPriceBetween.forEach(System.out::println);
        return allByPriceBetween;
    }

    @GetMapping("/products/{namePart}")
    public List<Product> findAllProductsContain(@PathVariable String namePart){
        List<Product> allProductsContain = productService.findAllProductsContain(namePart);
        return allProductsContain;
    }
}
