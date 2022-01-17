package ru.novikova.hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.novikova.hibernate.dao.ProductDao;
import ru.novikova.hibernate.dao.ServiceDao;
import ru.novikova.hibernate.dao.UserDao;

import javax.persistence.EntityManagerFactory;

@ComponentScan("ru.novikova.hibernate")
@Configuration
public class Config {
    EntityManagerFactory factory = new org.hibernate.cfg.Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    @Bean
    public ServiceDao serviceDao() {
        return new ServiceDao(factory);
    }

    @Bean
    public ProductDao productDao() {
        return new ProductDao(factory);
    }

    @Bean
    public UserDao userDao() {
        return new UserDao(factory);
    }
}
