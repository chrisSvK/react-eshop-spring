package com.react_eshop.reacteshop.api.dao.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Atribut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer atributId;

    @Column(name = "produkt_id", nullable = false)
    private Integer produktId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private Float cena;

    @Column(nullable = false)
    private Integer pocet;
}
