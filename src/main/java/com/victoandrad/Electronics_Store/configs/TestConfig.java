package com.victoandrad.Electronics_Store.configs;

import com.victoandrad.Electronics_Store.entities.User;
import com.victoandrad.Electronics_Store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Victor Andrade", "victor@gmail.com", "43991172893", "victor");
        User user2 = new User(null, "Luiza Aurora", "luiza@gmail.com", "432991172893", "luiza");
        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
