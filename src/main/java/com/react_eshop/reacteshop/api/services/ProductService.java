package com.react_eshop.reacteshop.api.services;

import com.react_eshop.reacteshop.api.dao.model.Produkt;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface ProductService {
    List<Produkt> findAll(Integer filter);

    List<Produkt> findByCategory(Integer category, Integer filter);

    List<Produkt> findPopular();
}
