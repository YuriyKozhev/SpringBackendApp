package com.yuriy.SpringBackendApp;

import com.yuriy.SpringBackendApp.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDataBase(UserRepository userRepository) {

        return args -> {
            userRepository.save(new User("john.smith@example.com", "john", "smith"));
            userRepository.save(new User("jack.smith@example.com", "jack", "smith"));
        };
    }
}
