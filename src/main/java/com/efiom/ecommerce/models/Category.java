package com.efiom.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Entity;
//import org.hibernate.annotations.Table;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Builder
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(name = "category_name")
    private String categoryName;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;
}
