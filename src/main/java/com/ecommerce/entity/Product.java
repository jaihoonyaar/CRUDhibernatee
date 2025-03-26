package com.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(nullable = false)
    private String name;
    @Column
    private float price;
    @Column
    private int stockQuantity;
    @ManyToOne
    @JoinColumn
    private Category category;

    public Product() {
        this.id = 0;
        this.name = null;
        this.price = 0;
        this.stockQuantity = 0;
        this.category = null;
    }

    public Product(String name, float price, int stockQuantity, Category category) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Product setPrice(float price) {
        this.price = price;
        return this;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public Product setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", category=" + category.getName() +
                '}';
    }
}
