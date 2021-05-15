package com.yuriy.SpringBackendApp;

import com.yuriy.SpringBackendApp.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDataBase(UserRepository userRepository) {

        List<User> users = userRepository.findAll();

        return args -> {
            if (users.isEmpty()) {
                userRepository.save(new User("john.smith@example.com", "john", "smith"));
                userRepository.save(new User("jack.smith@example.com", "jack", "smith"));
            }
        };
    }
}
