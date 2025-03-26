package com.ecommerce.entityhandlers;

import com.ecommerce.entity.Order;
import org.hibernate.SessionFactory;

public class OrderHelper {
    private final SessionFactory sessionFactory;

    public OrderHelper(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createOrder(Order order) {
        sessionFactory.inTransaction(session -> session.persist(order));
    }

    public Order getOrderById(int id) {
        Order order = sessionFactory.fromTransaction(session -> {
            return session.get(Order.class, id);
        });
        return order;
    }

    public void updateOrder(Order order) {
        sessionFactory.inTransaction(session -> {
            session.update(order);
        });
    }

    public void deleteOrder(Order order) {
        sessionFactory.inTransaction(session -> {
            session.delete(order);
        });
    }
}
