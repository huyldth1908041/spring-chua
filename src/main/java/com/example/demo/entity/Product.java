package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    //n -> 1 vs thg catehory
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id tự tăng
    private int id;
    private String name;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "categoryId")
    private Category category;

    @Column(insertable = false, updatable = false)
    private long categoryId;
}
