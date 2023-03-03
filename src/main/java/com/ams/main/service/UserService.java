package com.ams.main.service;

import com.ams.main.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public List<User> getAll() {
        //return Collections.emptyList();
        return users;

    }

    public boolean add(User user) {
        return users.add(user);
    }
}
