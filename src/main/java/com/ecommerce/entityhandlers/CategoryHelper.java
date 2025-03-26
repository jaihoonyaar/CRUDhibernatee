package com.ecommerce.entityhandlers;

import com.ecommerce.entity.Category;
import org.hibernate.SessionFactory;

public class CategoryHelper {
    private final SessionFactory sessionFactory;

    public CategoryHelper(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createCategory(Category category) {
        sessionFactory.inTransaction(session -> session.persist(category));
    }

    public Category getCategoryById(int id) {
        Category category = sessionFactory.fromTransaction(session -> {
            return session.get(Category.class, id);
        });
        return category;
    }

    public void updateCategory(Category category) {
        sessionFactory.inTransaction(session -> {
            session.update(category);
        });
    }

    public void deleteCategory(Category category) {
        sessionFactory.inTransaction(session -> {
            session.delete(category);
        });
    }
}
