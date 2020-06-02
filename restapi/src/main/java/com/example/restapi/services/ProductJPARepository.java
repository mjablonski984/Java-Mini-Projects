package com.example.restapi.services;

import com.example.restapi.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<obj, id> allows to make connection to the db
public interface ProductJPARepository extends JpaRepository<Product, Integer> {

}