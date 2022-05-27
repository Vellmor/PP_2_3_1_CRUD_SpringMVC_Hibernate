package ru.kata.springmvcapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.springmvcapp.repository.UserRepository;
import ru.kata.springmvcapp.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   private final UserRepository userRepository;

   @Autowired
   public UserServiceImp(UserRepository userDao) {
      this.userRepository = userDao;
   }

   @Override
   public void add(User user) {
      userRepository.save(user);
   }

   @Override
   public List<User> listUsers() {
      return (List<User>) userRepository.findAll();
   }

   @Override
   public User get(long id) { return userRepository.findById(id).get(); }

   @Override
   public void update(long id, User updatedUser) {
      User user = userRepository.findById(id).get();
      user.update(updatedUser);
      userRepository.save(user);
   }

   @Override
   public void delete(long id) {
      User user = userRepository.findById(id).get();
      userRepository.delete(user);
   }
}
