package com.yuriy.SpringBackendApp;

import com.yuriy.SpringBackendApp.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private final UserRepository userRepository;

    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String printMain() {
        logger.info("Main page is requested");
        return "This is the main page!";
    }

    @GetMapping("/greet")
    public String greet() {
        logger.info("Greet page is requested");
        return "Hello!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        logger.info("GET request to /users path to get list of all users");
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        logger.info("POST request to /users path to create user: {}", user);
        User newUser = userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
