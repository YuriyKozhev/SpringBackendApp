package com.yuriy.SpringBackendApp;

import com.yuriy.SpringBackendApp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String printMain() {
        return "This is the main page!";
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
