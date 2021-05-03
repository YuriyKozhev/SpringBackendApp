package com.yuriy.SpringBackendApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String printMain() {
        return "This is the main page!";
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello!";
    }
}
