package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUser(long userId) {
        return userList.get(0);
    }

    @PostConstruct
    private void initUserList() {
        userList.add(new User("John", "Mack"));
        userList.add(new User("Stevie", "Herman"));
    }
}
