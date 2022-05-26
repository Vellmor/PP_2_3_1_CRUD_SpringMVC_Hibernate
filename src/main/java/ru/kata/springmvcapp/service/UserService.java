package ru.kata.springmvcapp.service;


import ru.kata.springmvcapp.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User get(long id);

    void update(long id, User updatedUser);

    void delete(long id);
}
