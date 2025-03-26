package com.ecommerce.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Set<Product> products;

    public Category() {
        this.id = 0;
        this.name = null;
        this.description = null;
        this.products = null;
    }

    public Category(String name, String description, Set<Product> products) {
        this.name = name;
        this.description = description;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public Category setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Category setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder productList = new StringBuilder();
        for (Product product : products) {
            productList.append(product.getName()).append(",");
        }
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + productList +
                '}';
    }
}
