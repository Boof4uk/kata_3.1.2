package com.vova.Spring312.dao;

import com.vova.Spring312.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.vova.Spring312.models.User;
import java.util.List;

@Component
@Transactional
public class UserDAOImplementation implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public User findUser(int id) {
        return entityManager.find(User.class, id);
    }



    public List<User> getUserTable() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}
