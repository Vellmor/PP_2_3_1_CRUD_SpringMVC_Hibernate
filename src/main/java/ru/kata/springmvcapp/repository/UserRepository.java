package ru.kata.springmvcapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kata.springmvcapp.model.User;

/**
 * @author KalachikovMP
 * @create 2022-05-27 9:19
 **/
public interface UserRepository extends CrudRepository<User, Long> {
}
