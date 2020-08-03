package com.react_eshop.reacteshop.api.services;

import com.react_eshop.reacteshop.api.dao.model.Produkt;
//import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface ProductService {

    List<Produkt> findAll(Integer filter, Float pricerange);

    List<Produkt> findByCategory(Integer category, Integer filter, Float priceRange);

    List<Produkt> findCaj(Integer filter, Float priceRange);

    List<Produkt> findPopular();

    List<Produkt> findNew();

    Produkt getById(Integer id);
}
