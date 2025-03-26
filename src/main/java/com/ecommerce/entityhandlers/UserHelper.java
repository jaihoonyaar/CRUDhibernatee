package com.ecommerce.entityhandlers;

import com.ecommerce.entity.User;
import org.hibernate.SessionFactory;

public class UserHelper {
    private final SessionFactory sessionFactory;

    public UserHelper(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createUser(User user) {
        sessionFactory.inTransaction(session -> session.persist(user));
    }

    public User getUserById(int id) {
        User user = sessionFactory.fromTransaction(session -> {
            return session.get(User.class, id);
        });
        return user;
    }

    public void updateUser(User user) {
        sessionFactory.inTransaction(session -> {
            session.update(user);
        });
    }

    public void deleteUser(User user) {
        sessionFactory.inTransaction(session -> {
            session.delete(user);
        });
    }
}
