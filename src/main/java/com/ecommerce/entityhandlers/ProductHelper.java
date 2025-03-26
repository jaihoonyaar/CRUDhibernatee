package com.ecommerce.entityhandlers;

import com.ecommerce.entity.Product;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductHelper {
    private final SessionFactory sessionFactory;

    public ProductHelper(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createProduct(Product product) {
        sessionFactory.inTransaction(session -> session.persist(product));
    }

    public Product getProductById(int id) {
        Product product = sessionFactory.fromTransaction(session -> {
            return session.get(Product.class, id);
        });
        return product;
    }

    public void updateProduct(Product product) {
        sessionFactory.inTransaction(session -> {
            session.update(product);
        });
    }

    public void deleteProduct(Product product) {
        sessionFactory.inTransaction(session -> {
            session.delete(product);
        });
    }

    public Set<Product> getAllProducts() {
        List<Product> products = sessionFactory.fromTransaction(session -> {
            return session.createSelectionQuery("from Product", Product.class).getResultList();
        });
        return new HashSet<Product>(products);
    }
}
