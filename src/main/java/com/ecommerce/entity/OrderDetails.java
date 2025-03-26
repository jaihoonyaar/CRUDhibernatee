package com.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private int quantity;
    @Column
    private float unitPrice;
    @ManyToOne
    @JoinColumn
    private Order order;
    @ManyToOne
    @JoinColumn
    private Product product;

    public OrderDetails() {
        this.id = 0;
        this.quantity = 0;
        this.unitPrice = 0;
        this.order = null;
        this.product = null;
    }

    public OrderDetails(int quantity, float unitPrice, Order order, Product product) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.order = order;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public OrderDetails setId(int id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderDetails setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public OrderDetails setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderDetails setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public OrderDetails setProduct(Product product) {
        this.product = product;
        return this;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", orderId=" + order.getId() +
                ", product=" + product.getName() +
                '}';
    }
}
