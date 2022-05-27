package ru.kata.springmvcapp.repository;


import org.springframework.data.repository.CrudRepository;
import ru.kata.springmvcapp.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
