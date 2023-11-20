package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(int id);

    void addUser(User user);

    User updateUser(User updatedUser);

    void deleteUser(int id);
}