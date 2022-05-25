package ru.kata.springmvcapp.dao;


import ru.kata.springmvcapp.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User show(long id);

    void update(long id, User updatedUser);
}
