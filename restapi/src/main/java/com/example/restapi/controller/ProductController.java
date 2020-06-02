package com.example.restapi.controller;

import java.util.List;

import com.example.restapi.entities.Product;
import com.example.restapi.services.ProductJPARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    // create connection to the db
    @Autowired
    private ProductJPARepository productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @PostMapping("/products")
    public String addNewProduct(@RequestBody Product product) {
        productService.save(product);
        return "Added new product";
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.findById(id).get();
    }

    @PutMapping("/products/{id}")
    public String updateProductById(@PathVariable int id, @RequestBody Product product) {
        productService.findById(id).get();
        productService.save(product);
        return "Product updated";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable int id) {
        productService.deleteById(id);
        return "Product deleted";
    }

}