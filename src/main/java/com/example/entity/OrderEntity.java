package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product_id;

    // so luong dat hang
    @Column(name = "quantity")
    private Integer quantity;

    @Column(name="total_money")
    private Integer total_money;

    @Column(name = "status")
    private Boolean status = false;
    // constructors, getters, setters


    public OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public UserEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(UserEntity user_id) {
        this.user_id = user_id;
    }

    public ProductEntity getProduct_id() {
        return product_id;
    }

    public void setProduct_id(ProductEntity product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal_money() {
        return total_money;
    }

    public void setTotal_money(Integer total_money) {
        this.total_money = total_money;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
