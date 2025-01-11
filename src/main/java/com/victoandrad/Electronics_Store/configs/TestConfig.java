package com.victoandrad.Electronics_Store.configs;

import com.victoandrad.Electronics_Store.models.category.Category;
import com.victoandrad.Electronics_Store.models.order.Order;
import com.victoandrad.Electronics_Store.models.order.OrderStatus;
import com.victoandrad.Electronics_Store.models.user.User;
import com.victoandrad.Electronics_Store.repositories.CategoryRepository;
import com.victoandrad.Electronics_Store.repositories.OrderRepository;
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

    @Autowired
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
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
        categoryRepository.saveAll(Arrays.asList(category1, category2));
    }
}
