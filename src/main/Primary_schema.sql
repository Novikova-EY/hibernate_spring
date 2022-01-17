
use hibernate_db;

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);
INSERT INTO users (name) VALUES
("Ivan"),
("Sergey"),
("Vlad"),
("Alex");

CREATE TABLE IF NOT EXISTS products (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10 , 2)
);
INSERT INTO products (title, price) VALUES
("Shoe", 1500),
("Hat", 2000),
("Shirt", 1000),
("Jacket", 1200),
("Skirt", 500);

CREATE TABLE IF NOT EXISTS orders
(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
order_date DATE,
FOREIGN KEY (user_id) REFERENCES users (id)
);
INSERT INTO orders (id, user_id, order_date) VALUES
(1, 1, "2020-11-18"),
(2, 1, "2020-12-01"),
(3, 2, "2020-06-15"),
(4, 3, "2020-01-05"),
(5, 3, "2021-02-01");

CREATE TABLE IF NOT EXISTS orders_products
(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
order_id INT NOT NULL,
product_id INT NOT NULL,
amount INT NOT NULL,
FOREIGN KEY (order_id) REFERENCES orders (id),
FOREIGN KEY (product_id) REFERENCES products (id)
);
INSERT INTO orders_products (order_id, product_id, amount) VALUES
(1, 1, 3),
(2, 3, 2),
(3, 2, 2),
(3, 5, 1),
(4, 1, 1),
(4, 2, 1),
(4, 3, 1),
(5, 2, 4);
