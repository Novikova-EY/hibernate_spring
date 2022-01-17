package ru.novikova.hibernate.dao;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class ServiceDao {

    private EntityManagerFactory factory;

    public ServiceDao(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public List findProductNamesByUserID(long id) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            List resultList = em
                    .createNativeQuery(
                            "SELECT " +
                                    "p.title " +
                                    "FROM orders_products op " +
                                    "JOIN products p " +
                                    "ON op.product_id = p.id " +
                                    "JOIN orders " +
                                    "ON op.order_id = orders.id " +
                                    "JOIN users u " +
                                    "ON orders.user_id = u.id " +
                                    "WHERE u.id = " + id + " " +
                                    "GROUP BY p.title")
                    .getResultList();
            em.getTransaction().commit();
            return resultList;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List findUserNamesByProductID(long id) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            List resultList = em
                    .createNativeQuery(
                            "SELECT " +
                                    "u.name " +
                                    "FROM orders_products op " +
                                    "JOIN products p " +
                                    "ON op.product_id = p.id " +
                                    "JOIN orders " +
                                    "ON op.order_id = orders.id " +
                                    "JOIN users u " +
                                    "ON orders.user_id = u.id " +
                                    "WHERE p.id = " + id + " " +
                                    "GROUP BY u.name")
                    .getResultList();
            em.getTransaction().commit();
            return resultList;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
