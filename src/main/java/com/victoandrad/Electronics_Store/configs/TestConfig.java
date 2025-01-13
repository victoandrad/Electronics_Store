package com.victoandrad.Electronics_Store.configs;

import com.victoandrad.Electronics_Store.models.category.Category;
import com.victoandrad.Electronics_Store.models.order.Order;
import com.victoandrad.Electronics_Store.models.order.OrderStatus;
import com.victoandrad.Electronics_Store.models.product.Product;
import com.victoandrad.Electronics_Store.models.user.User;
import com.victoandrad.Electronics_Store.repositories.CategoryRepository;
import com.victoandrad.Electronics_Store.repositories.OrderRepository;
import com.victoandrad.Electronics_Store.repositories.ProductRepository;
import com.victoandrad.Electronics_Store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Victor Andrade", "victor@gmail.com", "43991172893", "victor");
        User user2 = new User(null, "Luiza Aurora", "luiza@gmail.com", "432991172893", "luiza");
        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, user1);
        Order order2 = new Order(null, Instant.now(), OrderStatus.PAID, user2);
        orderRepository.saveAll(Arrays.asList(order1, order2));

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(category2);
        p2.getCategories().add(category1);
        p2.getCategories().add(category3);
        p3.getCategories().add(category3);
        p4.getCategories().add(category3);
        p5.getCategories().add(category2);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
