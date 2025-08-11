package com.inventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String productId;
    @Column
    private String productName;
    @Column
    private int quantity;
    @Column
    private double price;
    @Column
    private String sku; // Stock Keeping Unit
}
