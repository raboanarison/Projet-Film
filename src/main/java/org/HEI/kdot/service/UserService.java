package org.HEI.kdot.service;

import org.HEI.kdot.modele.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public User findById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    public List<User> findAll() {
        return List.copyOf(users);
    }

    public void deleteUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }
}