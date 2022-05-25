package ru.kata.springmvcapp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.springmvcapp.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User show(long id) {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User u where u.id = :id");
      query.setParameter("id", id);
      return query.getSingleResult();
   }

   @Override
   @SuppressWarnings("unchecked")
   public void update(long id, User updatedUser) {
      //TODO change realisation
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User u where u.id = :id");
      query.setParameter("id", id);
   }

}
