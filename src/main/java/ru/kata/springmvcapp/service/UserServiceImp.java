package ru.kata.springmvcapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.springmvcapp.dao.UserDao;
import ru.kata.springmvcapp.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImp(@Qualifier("userDaoEMImp") UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User get(long id) { return userDao.show(id); }

   @Override
   public void update(long id, User updatedUser) {
      userDao.update(id, updatedUser);
   }

   @Override
   public void delete(long id) {
      userDao.delete(id);
   }
}
