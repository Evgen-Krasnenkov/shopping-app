package com.kras.shoppingapp.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
@Component
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal price;
}
