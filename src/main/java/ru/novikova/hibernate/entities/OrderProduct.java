package ru.novikova.hibernate.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="orders_products")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private int amount;

    @ManyToMany
    @JoinTable(
            name = "orderProduct_orders",
            joinColumns = @JoinColumn(name = "orderProduct_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orders;

    @ManyToMany
    @JoinTable(
            name = "orderProduct_product",
            joinColumns = @JoinColumn(name = "orderProduct_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public OrderProduct() {
    }

    public OrderProduct(Long id, int amount, List<Order> orders, List<Product> products) {
        this.id = id;
        this.amount = amount;
        this.orders = orders;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", amount=" + amount +
                ", orders=" + orders +
                ", products=" + products +
                '}';
    }
}
