package ru.kata.springmvcapp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.springmvcapp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class UserDaoEMImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(long id, User updatedUser) {
        User user = entityManager.find(User.class, id);
        user.setFirstName(updatedUser.getFirstName());
        user.setSecondName(updatedUser.getSecondName());
        user.setAge(updatedUser.getAge());
        user.setGender(updatedUser.getGender());
        entityManager.merge(user);
    }

    @Override
    public void delete(long id) {
        User user = show(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
