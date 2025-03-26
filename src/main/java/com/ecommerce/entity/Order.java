package com.ecommerce.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date orderDate;
    @Column(nullable = false)
    private float totalAmount;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private Set<OrderDetails> orderDetails;

    public Order() {
        this.id = 0;
        this.orderDate = null;
        this.totalAmount = 0;
        this.user = null;
        this.orderDetails = null;
    }

    public Order(Date orderDate, float totalAmount, User user, Set<OrderDetails> orderDetails) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.user = user;
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public Order setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public Order setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", user=" + user.getUsername() +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
