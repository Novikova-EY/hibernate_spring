package ru.novikova.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.novikova.hibernate.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Component
public class UserDao {

    private EntityManagerFactory factory;

    public UserDao(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public void insert(User user) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Optional<User> findById(Long id) {
        EntityManager em = factory.createEntityManager();
        try {
            User user = em.find(User.class, id);
            return Optional.ofNullable(user);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<User> findAll() {
        EntityManager em = factory.createEntityManager();
        try {
            List<User> users = em.createQuery("SELECT u FROM User u").getResultList();
            return users;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteById(Long id) throws IllegalArgumentException {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            em.remove(user);
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            System.out.println("Данного пользователя не существует.");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void saveOrUpdate(User user) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
