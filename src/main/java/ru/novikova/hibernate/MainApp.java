package ru.novikova.hibernate;

import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.novikova.hibernate.dao.ProductDao;
import ru.novikova.hibernate.dao.ServiceDao;
import ru.novikova.hibernate.dao.UserDao;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ProductDao productDao = context.getBean("productDao", ProductDao.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);
        ServiceDao serviceDao = context.getBean("serviceDao", ServiceDao.class);


        List productsByID = serviceDao.findProductNamesByUserID(1L);
        System.out.println(productsByID);

        List namesByUserIDByID = serviceDao.findUserNamesByProductID(2L);
        System.out.println(namesByUserIDByID);

    }
}
