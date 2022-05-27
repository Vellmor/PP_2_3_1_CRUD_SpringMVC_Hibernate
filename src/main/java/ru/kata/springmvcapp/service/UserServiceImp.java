package ru.kata.springmvcapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.springmvcapp.dao.UserDao;
import ru.kata.springmvcapp.model.User;
import ru.kata.springmvcapp.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   private final UserRepository repo;
   private final UserDao userDao;

   @Autowired
   public UserServiceImp(@Qualifier("userDaoEMImp") UserDao userDao, UserRepository repo) {
      this.userDao = userDao;
      this.repo = repo;
   }

   @Override
   public void add(User user) {
//      userDao.add(user);
      repo.save(user);
   }

   @Override
   public List<User> listUsers() {
//      return userDao.listUsers();
      return (List<User>) repo.findAll();
   }

   @Override
   public User get(long id) {
//      return userDao.show(id);
      return repo.findById(id).get();
   }

   @Override
   public void update(long id, User updatedUser) {
//      userDao.update(id, updatedUser);
      User user = repo.findById(id).get();
      user.setFirstName(updatedUser.getFirstName());
      user.setSecondName(updatedUser.getSecondName());
      user.setAge(updatedUser.getAge());
      user.setGender(updatedUser.getGender());
      repo.save(user);
   }

   @Override
   public void delete(long id) {
//      userDao.delete(id);
      User user = repo.findById(id).get();
      repo.delete(user);
   }
}
