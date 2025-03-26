package com.ecommerce;

import com.ecommerce.entity.*;
import com.ecommerce.entityhandlers.*;
import org.hibernate.SessionFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

public class App {
    HibernateUtil hibernateUtil;
    SessionFactory sessionFactory;
    CategoryHelper categoryHelper;
    ProductHelper productHelper;
    OrderHelper orderHelper;
    OrderDetailsHelper orderDetailsHelper;
    UserHelper userHelper;

    App() {
        hibernateUtil = new HibernateUtil();
        sessionFactory = hibernateUtil.getSessionFactory();
        categoryHelper = new CategoryHelper(sessionFactory);
        productHelper = new ProductHelper(sessionFactory);
        orderHelper = new OrderHelper(sessionFactory);
        orderDetailsHelper = new OrderDetailsHelper(sessionFactory);
        userHelper = new UserHelper(sessionFactory);
    }

    public void createCategoryAndProducts() {
        Category category1 = new Category()
                .setName("Food Items")
                .setDescription("Contains food items");
        Category category2 = new Category()
                .setName("Kitchen Tools")
                .setDescription("Contains kitchen tools");

        Product p1 = new Product()
                .setName("Tomato")
                .setCategory(category1)
                .setPrice(50)
                .setStockQuantity(200);

        Product p2 = new Product()
                .setName("Carrot")
                .setCategory(category1)
                .setPrice(80)
                .setStockQuantity(100);

        Product p3 = new Product()
                .setName("Cheese")
                .setCategory(category1)
                .setPrice(120)
                .setStockQuantity(50);

        Product p4 = new Product()
                .setName("Spoons")
                .setCategory(category2)
                .setPrice(200)
                .setStockQuantity(150);

        Product p5 = new Product()
                .setName("Fork")
                .setCategory(category2)
                .setPrice(150)
                .setStockQuantity(70);

        category1.setProducts(Set.of(p1, p2, p3));
        category2.setProducts(Set.of(p4, p5));

        categoryHelper.createCategory(category1);
        categoryHelper.createCategory(category2);
    }

    public void displayAllProducts() {
        Set<Product> products = productHelper.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void createUserAndOrder() throws ParseException {
        User user1 = new User()
                .setRole(Role.CUSTOMER)
                .setUsername("TestUser")
                .setPassword("12345")
                .setEmail("test@example.com");
        Order order1 = new Order()
                .setOrderDate(new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2019"))
                .setUser(user1)
                .setTotalAmount(500);
        OrderDetails od1 = new OrderDetails()
                .setProduct(productHelper.getProductById(1))
                .setQuantity(4)
                .setUnitPrice(45)
                .setOrder(order1);
        OrderDetails od2 = new OrderDetails()
                .setProduct(productHelper.getProductById(2))
                .setQuantity(6)
                .setUnitPrice(45)
                .setOrder(order1);
        order1.setOrderDetails(Set.of(od1, od2));
        user1.setOrders(Set.of(order1));
        userHelper.createUser(user1);
        System.out.println("Created User and Order with following details:\n" + userHelper.getUserById(1));
    }

    public static void main(String[] args) throws ParseException {
        App app = new App();
        app.createCategoryAndProducts();
        app.displayAllProducts();
        app.createUserAndOrder();
    }
}
