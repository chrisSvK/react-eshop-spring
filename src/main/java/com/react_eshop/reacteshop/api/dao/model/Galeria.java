package com.react_eshop.reacteshop.api.dao.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Galeria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer galeriaId;

    @Column(name = "produkt_id", nullable = false)
    private Integer produktId;

//    @ManyToOne
//    @JoinColumn(name="produkt_id", nullable=false)
//    private Produkt produkt;

    @Column(nullable = false)
    private String name;

}