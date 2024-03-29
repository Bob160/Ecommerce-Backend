package com.efiom.ecommerce.repositories;

import com.efiom.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Optional<Product> findByProductName(String name);
    Optional<Product> findByName(String name);
    Optional<Product> findById(Long id);
}
