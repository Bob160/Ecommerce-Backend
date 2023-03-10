package com.efiom.ecommerce.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imageUrl;

    private int quantity;

    private BigDecimal price;

    private String description;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
