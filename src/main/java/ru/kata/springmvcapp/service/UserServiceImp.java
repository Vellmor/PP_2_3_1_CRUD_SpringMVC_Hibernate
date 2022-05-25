package ru.kata.springmvcapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.springmvcapp.dao.UserDao;
import ru.kata.springmvcapp.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User get(long id) { return userDao.show(id); }

   @Override
   public void update(long id, User updatedUser) {
      userDao.update(id, updatedUser);
   }

}
