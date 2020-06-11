package com.react_eshop.reacteshop.api.dao.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Kategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer kategoriaId;

    @Column(name = "parent_kategoria_id", nullable = false)
    private Integer parentKategoriaId;

    @Column(nullable = false)
    private String name;

}
