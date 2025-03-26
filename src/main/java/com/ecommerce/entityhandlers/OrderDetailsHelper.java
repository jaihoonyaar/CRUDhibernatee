package com.ecommerce.entityhandlers;

import com.ecommerce.entity.OrderDetails;
import org.hibernate.SessionFactory;

public class OrderDetailsHelper {
    private final SessionFactory sessionFactory;

    public OrderDetailsHelper(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createOrderDetails(OrderDetails orderDetails) {
        sessionFactory.inTransaction(session -> session.persist(orderDetails));
    }

    public OrderDetails getOrderDetailsById(int id) {
        OrderDetails orderDetails = sessionFactory.fromTransaction(session -> {
            return session.get(OrderDetails.class, id);
        });
        return orderDetails;
    }

    public void updateOrderDetails(OrderDetails orderDetails) {
        sessionFactory.inTransaction(session -> {
            session.update(orderDetails);
        });
    }

    public void deleteOrderDetails(OrderDetails orderDetails) {
        sessionFactory.inTransaction(session -> {
            session.delete(orderDetails);
        });
    }
}
