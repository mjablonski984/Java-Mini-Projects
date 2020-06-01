package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity annotation specifies that the class is an entity and is mapped to a database table
@Entity
public class Product {
    private Long id;
    private String name;
    private String brand;
    private String madein;
    private float price;

    protected Product() {
    }

    // JPA annotation @Id - use to specify the primary key of an entity.
    // @GeneratedValue - used to configure the way of increment of the column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}