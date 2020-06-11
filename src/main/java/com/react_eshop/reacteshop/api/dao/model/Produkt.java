package com.react_eshop.reacteshop.api.dao.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer produktId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String popis;

//    @Column(name = "kategoria_id", nullable = false)
//    private Integer kategoriaId;

    @Column(name = "datum_pridania", nullable = false)
    private Date datumPridania;

    @Column(name = "pocet_objednani", nullable = false)
    private Integer pocetObjednani;


    @ManyToOne
    @JoinColumn(name = "kategoria_id", nullable = false)
    private Kategoria kategoria;

    @OneToMany(mappedBy = "produktId")
    private Set<Galeria> galeria;

}
