package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private Counter counter;
    private UserService userService;

    public UserController(MeterRegistry meterRegistry, UserService userService) {
        counter = meterRegistry.counter("demo_all_user_request");
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        counter.increment();

        List<User> list = userService.getAllUsers();
        return list;
    }

    @Timed("demo_get_user")
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        return user;
    }
}
