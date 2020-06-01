package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository interface from Spring Data JPA defines standard CRUD methods, plus JPA-specific operations.
public interface ProductRepository extends JpaRepository<Product, Long> {

}