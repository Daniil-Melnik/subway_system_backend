package com.subway.system.service;

import java.util.List;

import com.subway.system.model.User;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public boolean activateUser(String s);
}