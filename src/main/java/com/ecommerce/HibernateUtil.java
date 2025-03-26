package com.ecommerce;

import com.ecommerce.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import static org.hibernate.cfg.AvailableSettings.*;

public class HibernateUtil {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(OrderDetails.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
        HibernateUtil util = new HibernateUtil();
        util.getSessionFactory();
    }
}
